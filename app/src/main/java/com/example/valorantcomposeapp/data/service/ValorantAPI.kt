package com.example.valorantcomposeapp.data.service

import com.example.valorantcomposeapp.data.dto.agents.AgentDetailResponse
import com.example.valorantcomposeapp.data.dto.agents.AgentsResponse
import com.example.valorantcomposeapp.data.dto.maps.MapDetailResponse
import com.example.valorantcomposeapp.data.dto.maps.MapsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ValorantAPI {

    @GET("v1/agents/?isPlayableCharacter=true")
    suspend fun getAllAgents() : AgentsResponse

    @GET("v1/agents/{agentUuid}")
    suspend fun getAgentByUUID(
        @Path("agentUuid") uuid : String
    ) : AgentDetailResponse

    @GET("v1/maps")
    suspend fun getAllMaps() : MapsResponse

    @GET("v1/maps/{mapUuid}")
    suspend fun getMapByUUID(
        @Path("mapUuid") uuid : String
    ) : MapDetailResponse

    companion object {
        const val BASE_URL = "https://valorant-api.com/"
    }
}