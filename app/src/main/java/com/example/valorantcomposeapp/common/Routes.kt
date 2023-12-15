package com.example.valorantcomposeapp.common

sealed class Routes(val route : String) {
    data object Splash : Routes("splash")
    data object Agents : Routes("agents")
    data object AgentDetail : Routes("agent_detail")
    data object Maps : Routes("maps")
    data object MapDetail : Routes("map_detail")
    data object Weapons : Routes("weapons")
    data object WeaponsDetail : Routes("weapons_detail")
    data object Tiers : Routes("tiers")
}