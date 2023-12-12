package com.example.valorantcomposeapp.di

import com.example.valorantcomposeapp.data.repository.ValorantRepositoryImpl
import com.example.valorantcomposeapp.data.service.ValorantAPI
import com.example.valorantcomposeapp.domain.repository.ValorantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(api: ValorantAPI): ValorantRepository {
        return ValorantRepositoryImpl(api)
    }
}