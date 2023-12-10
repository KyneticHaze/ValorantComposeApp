package com.example.valorantcomposeapp.data.repository

import com.example.valorantcomposeapp.data.remote.AgentDetailResponse
import com.example.valorantcomposeapp.data.remote.AgentsResponse
import com.example.valorantcomposeapp.data.service.AgentsAPI
import com.example.valorantcomposeapp.domain.repository.AgentRepository

class AgentRepositoryImpl(
    private val api: AgentsAPI
) : AgentRepository {
    override suspend fun getAgents(): AgentsResponse = api.getAllAgents()

    override suspend fun getAgentByUUID(uuid: String): AgentDetailResponse = api.getAgentByUUID(uuid)
}