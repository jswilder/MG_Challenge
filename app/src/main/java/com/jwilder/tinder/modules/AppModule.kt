package com.jwilder.flickr.modules

import com.jwilder.tinder.remote.GifWebService
import com.jwilder.tinder.repository.GifRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

/**
 * Hilt module which provides the singleton implementation of the [GifRepository]
 * & the default dispatcher for coroutines
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesGifRepository(
        service: GifWebService,
        dispatcher: CoroutineDispatcher
    ) = GifRepository(
        service,
        dispatcher
    )

    @Provides
    fun providesRepoDispatcher() = Dispatchers.IO
}