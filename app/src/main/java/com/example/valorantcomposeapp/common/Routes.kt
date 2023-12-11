package com.example.valorantcomposeapp.common

sealed class Routes(val route : String) {
    data object Agents : Routes("agents")
    data object Maps : Routes("maps")
    data object Weapons : Routes("weapons")
    data object Tiers : Routes("tiers")
}