package com.example.samplejetpackcompose

import com.example.samplejetpackcompose.data.network.ApiService
import com.example.samplejetpackcompose.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesPostRepository(apiService: ApiService) : UserRepository{
        return UserRepository(apiService)
    }
}