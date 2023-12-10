package com.example.valorantcomposeapp.di

import com.example.valorantcomposeapp.data.repository.AgentRepositoryImpl
import com.example.valorantcomposeapp.data.service.AgentsAPI
import com.example.valorantcomposeapp.domain.repository.AgentRepository
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
    fun provideRepository(api: AgentsAPI): AgentRepository {
        return AgentRepositoryImpl(api)
    }
}