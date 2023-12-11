package com.example.valorantcomposeapp.data.service

import com.example.valorantcomposeapp.data.remote.AgentDetailResponse
import com.example.valorantcomposeapp.data.remote.AgentsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AgentsAPI {

    @GET("v1/agents/?isPlayableCharacter=true")
    suspend fun getAllAgents() : AgentsResponse

    @GET("v1/agents/{agentUuid}")
    suspend fun getAgentByUUID(
        @Path("agentUuid") uuid : String
    ) : AgentDetailResponse

    companion object {
        const val BASE_URL = "https://valorant-api.com/"
    }
}