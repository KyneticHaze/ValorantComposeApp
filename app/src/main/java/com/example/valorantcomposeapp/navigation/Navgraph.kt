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
import com.example.valorantcomposeapp.presentation.agentDetail.AgentDetailScreen
import com.example.valorantcomposeapp.presentation.all_agents.AgentsScreen

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
                navigateToDetail = {
                    navController.navigate("${Routes.Maps.route}/$it")
                }
            )
        }
        composable(route = "${Routes.Maps.route}/{agentUuid}") {
            AgentDetailScreen()
        }
    }
}