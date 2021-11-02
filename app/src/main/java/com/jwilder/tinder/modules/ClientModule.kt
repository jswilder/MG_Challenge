package com.jwilder.flickr.modules

import com.jwilder.tinder.remote.GifWebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ClientModule {

    @Singleton
    @Provides
    fun providesMovieDetailsWebService(): GifWebService {
        val client: OkHttpClient = OkHttpClient().newBuilder().build()
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(GifWebService::class.java)
    }

    companion object {
        private const val BASE_URL = "https://api.giphy.com/v1/gifs/"
    }
}