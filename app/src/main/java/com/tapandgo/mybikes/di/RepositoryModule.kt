package com.tapandgo.mybikes.di

import com.tapandgo.mybikes.network.MyBikesService
import com.tapandgo.mybikes.repository.MyBikesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMyBikesRepository(
        service: MyBikesService
    ) = MyBikesRepository(service)
}