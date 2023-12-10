package com.example.valorantcomposeapp.common

sealed class Routes(val routes : String) {
    data object Agents : Routes("agents")
    data object AgentDetail : Routes("agent")
}