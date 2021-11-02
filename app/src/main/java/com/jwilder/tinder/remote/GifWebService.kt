package com.jwilder.tinder.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GifWebService {

    /**
     * @param limit The maximum number of objects to return
     * @param offset Specifies the starting position of the results: Default: “0” Max: “4999”
     * @param rating Filters results by specified rating. Acceptable values include g, pg, pg-13, r.
     */
    @GET("trending")
    suspend fun fetchTrendingGifs(
        @Query("api_key") key: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("rating") rating: String
    ): Response<ResponseModel>
}