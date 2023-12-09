package com.example.valorantcomposeapp.di

import com.example.valorantcomposeapp.common.Constants
import com.example.valorantcomposeapp.data.repository.AgentRepositoryImpl
import com.example.valorantcomposeapp.data.service.AgentsAPI
import com.example.valorantcomposeapp.domain.repository.AgentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAgentsAPI() : AgentsAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AgentsAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: AgentsAPI) : AgentRepository {
        return AgentRepositoryImpl(api)
    }
}