package com.example.valorantcomposeapp.data.repository

import com.example.valorantcomposeapp.data.dto.agents.AgentDetailResponse
import com.example.valorantcomposeapp.data.dto.agents.AgentsResponse
import com.example.valorantcomposeapp.data.dto.maps.MapDetailResponse
import com.example.valorantcomposeapp.data.dto.maps.MapsResponse
import com.example.valorantcomposeapp.data.dto.weapons.WeaponDetailResponse
import com.example.valorantcomposeapp.data.dto.weapons.WeaponResponse
import com.example.valorantcomposeapp.data.service.ValorantAPI
import com.example.valorantcomposeapp.domain.repository.ValorantRepository

class ValorantRepositoryImpl(
    private val api: ValorantAPI
) : ValorantRepository {
    override suspend fun getAgents(): AgentsResponse = api.getAllAgents()

    override suspend fun getAgentByUUID(uuid: String): AgentDetailResponse = api.getAgentByUuid(uuid)

    override suspend fun getAllMaps(): MapsResponse = api.getAllMaps()

    override suspend fun getMapByUUID(uuid: String): MapDetailResponse = api.getMapByUuid(uuid)

    override suspend fun getAllWeapons(): WeaponResponse = api.getAllWeapons()

    override suspend fun getWeaponByUuid(weaponUuid: String): WeaponDetailResponse = api.getWeaponByUuid(weaponUuid)
}