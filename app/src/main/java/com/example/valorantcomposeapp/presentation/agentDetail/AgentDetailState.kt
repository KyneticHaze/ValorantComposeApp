package com.example.valorantcomposeapp.presentation.agentDetail

import com.example.valorantcomposeapp.domain.model.Agent

data class AgentDetailState(
    val isLoading: Boolean = false,
    val agent: Agent? = null,
    val error: String = ""
)
