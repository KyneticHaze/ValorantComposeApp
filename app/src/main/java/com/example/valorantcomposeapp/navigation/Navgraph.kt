package com.example.valorantcomposeapp.navigation

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.valorantcomposeapp.common.Routes
import com.example.valorantcomposeapp.presentation.agents.agentDetail.AgentDetailScreen
import com.example.valorantcomposeapp.presentation.agents.all_agents.AgentsScreen
import com.example.valorantcomposeapp.presentation.maps.all_maps.MapsScreen
import com.example.valorantcomposeapp.presentation.maps.map_detail.MapDetailScreen

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun NavGraphComponent(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Agents.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(Routes.Agents.route) {
            AgentsScreen(
                navigateToAgentDetail = {
                    navController.navigate("${Routes.AgentDetail.route}/$it")
                }
            )
        }
        composable(route = "${Routes.AgentDetail.route}/{agentUuid}") {
            AgentDetailScreen()
        }

        composable(route = Routes.Maps.route) {
            MapsScreen(
                navigateToMapDetail = {
                    navController.navigate("${Routes.MapDetail.route}/$it")
                }
            )
        }
        composable(route = "${Routes.MapDetail.route}/{mapUuid}") {
            MapDetailScreen()
        }
    }
}