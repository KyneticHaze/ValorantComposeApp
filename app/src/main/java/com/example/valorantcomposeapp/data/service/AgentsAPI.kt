package com.example.valorantcomposeapp.data.service

import com.example.valorantcomposeapp.data.remote.Agent
import com.example.valorantcomposeapp.data.remote.AgentsDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface AgentsAPI {

    @GET("agents")
    suspend fun getAllAgents() : AgentsDTO

    @GET("agents/{uuid}")
    suspend fun getAgentByUUID(
        @Query("uuid") uuid : String
    ) : Agent

}