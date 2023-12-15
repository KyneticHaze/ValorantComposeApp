package com.example.valorantcomposeapp.data.service

import com.example.valorantcomposeapp.data.dto.agents.AgentDetailResponse
import com.example.valorantcomposeapp.data.dto.agents.AgentsResponse
import com.example.valorantcomposeapp.data.dto.maps.MapDetailResponse
import com.example.valorantcomposeapp.data.dto.maps.MapsResponse
import com.example.valorantcomposeapp.data.dto.weapons.WeaponDetailResponse
import com.example.valorantcomposeapp.data.dto.weapons.WeaponResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ValorantAPI {

    @GET("v1/agents/?isPlayableCharacter=true")
    suspend fun getAllAgents() : AgentsResponse

    @GET("v1/agents/{agentUuid}")
    suspend fun getAgentByUuid(
        @Path("agentUuid") uuid : String
    ) : AgentDetailResponse

    @GET("v1/maps")
    suspend fun getAllMaps() : MapsResponse

    @GET("v1/maps/{mapUuid}")
    suspend fun getMapByUuid(
        @Path("mapUuid") uuid : String
    ) : MapDetailResponse

    @GET("v1/weapons")
    suspend fun getAllWeapons() : WeaponResponse

    @GET("v1/weapons/{weaponUuid}")
    suspend fun getWeaponByUuid(
        @Path("weaponUuid") weaponUuid : String
    ) : WeaponDetailResponse

    companion object {
        const val BASE_URL = "https://valorant-api.com/"
    }
}