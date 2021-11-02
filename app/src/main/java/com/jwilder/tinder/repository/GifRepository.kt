package com.jwilder.tinder.repository

import com.jwilder.tinder.remote.GifWebService
import com.jwilder.tinder.remote.ResponseModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import retrofit2.Response
import javax.inject.Inject

class GifRepository @Inject constructor(
    private val service: GifWebService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun fetchTrendingGifs(): Response<ResponseModel> {
        return coroutineScope {
            val response = async(dispatcher) {
                service.fetchTrendingGifs(
                    "g9NTHgKtvXGs9E4lEn8FrBSvg4z1F61d",
                    32,
                    0,
                    "r"
                )
            }
            response.await()
        }
    }
}