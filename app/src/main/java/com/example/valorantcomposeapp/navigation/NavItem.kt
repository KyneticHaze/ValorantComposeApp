package com.example.valorantcomposeapp.navigation

import com.example.valorantcomposeapp.R
import com.example.valorantcomposeapp.common.Routes

sealed class NavItem(
    val title: String,
    val icon : Int,
    val route : String
) {
    data object Agents : NavItem(
        title = "Agents",
        icon = R.drawable.ic_agents,
        route = Routes.Agents.route
    )

    data object Maps : NavItem(
        title = "Maps",
        icon = R.drawable.ic_maps,
        route = Routes.Maps.route
    )

    data object Weapons : NavItem(
        title = "Weapons",
        icon = R.drawable.ic_weapons,
        route = Routes.Weapons.route
    )

    data object Tiers : NavItem(
        title = "Tiers",
        icon = R.drawable.ic_tiers,
        route = Routes.Tiers.route
    )
}