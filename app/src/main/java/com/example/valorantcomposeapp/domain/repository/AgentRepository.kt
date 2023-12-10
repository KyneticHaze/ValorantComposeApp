package com.example.valorantcomposeapp.domain.repository

import com.example.valorantcomposeapp.data.remote.AgentDetailResponse
import com.example.valorantcomposeapp.data.remote.AgentsResponse

interface AgentRepository {

    suspend fun getAgents() : AgentsResponse

    suspend fun getAgentByUUID(uuid : String) : AgentDetailResponse
}