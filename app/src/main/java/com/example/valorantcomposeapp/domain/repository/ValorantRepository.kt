package com.example.valorantcomposeapp.domain.repository

import com.example.valorantcomposeapp.data.dto.agents.AgentDetailResponse
import com.example.valorantcomposeapp.data.dto.agents.AgentsResponse
import com.example.valorantcomposeapp.data.dto.maps.MapDetailResponse
import com.example.valorantcomposeapp.data.dto.maps.MapsResponse
import com.example.valorantcomposeapp.data.dto.weapons.WeaponDetailResponse
import com.example.valorantcomposeapp.data.dto.weapons.WeaponResponse

interface ValorantRepository {

    suspend fun getAgents() : AgentsResponse

    suspend fun getAgentByUUID(uuid : String) : AgentDetailResponse

    suspend fun getAllMaps() : MapsResponse

    suspend fun getMapByUUID(uuid : String) : MapDetailResponse

    suspend fun getAllWeapons() : WeaponResponse

    suspend fun getWeaponByUuid(weaponUuid : String) : WeaponDetailResponse
}