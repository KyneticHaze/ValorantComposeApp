package com.example.valorantcomposeapp.presentation.agents.all_agents

import com.example.valorantcomposeapp.domain.model.Agent

data class AgentsState(
    val isLoading : Boolean = false,
    val agents : List<Agent> = emptyList(),
    val error : String = ""
)
