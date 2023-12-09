package com.example.valorantcomposeapp.data.repository

import com.example.valorantcomposeapp.data.mapper.toModelAgent
import com.example.valorantcomposeapp.data.service.AgentsAPI
import com.example.valorantcomposeapp.domain.model.ModelAgent
import com.example.valorantcomposeapp.domain.repository.AgentRepository

class AgentRepositoryImpl(
    private val api: AgentsAPI
) : AgentRepository {
    override suspend fun getAgents(): List<ModelAgent> {
        return api.getAllAgents().map { it.toModelAgent() }
    }

    override suspend fun getAgentByUUID(uuid: String): ModelAgent {
        return api.getAgentByUUID(uuid).toModelAgent()
    }
}