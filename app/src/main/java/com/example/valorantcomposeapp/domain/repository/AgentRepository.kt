package com.example.valorantcomposeapp.domain.repository

import com.example.valorantcomposeapp.common.Resource
import com.example.valorantcomposeapp.domain.model.ModelAgent

interface AgentRepository {

    suspend fun getAgents() : List<ModelAgent>

    suspend fun getAgentByUUID(uuid : String) : ModelAgent
}