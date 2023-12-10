package com.example.valorantcomposeapp.di

import com.example.valorantcomposeapp.data.service.AgentsAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideAgentsAPI() : AgentsAPI {
        return Retrofit.Builder()
            .baseUrl(AgentsAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AgentsAPI::class.java)
    }
}