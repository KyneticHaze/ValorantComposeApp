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
import com.example.valorantcomposeapp.presentation.splash.SplashScreen
import com.example.valorantcomposeapp.presentation.tiers.TiersScreen
import com.example.valorantcomposeapp.presentation.weapons.weaponDetail.WeaponDetailScreen
import com.example.valorantcomposeapp.presentation.weapons.all_weapons.WeaponsScreen

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun NavGraphComponent(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Splash.route,
        modifier = Modifier.padding(paddingValues)
    ) {

        composable(Routes.Splash.route) {
            SplashScreen {
                navController.navigate(Routes.Agents.route) {
                    popUpTo(Routes.Splash.route) {
                        inclusive = true
                    }
                }
            }
        }

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
        composable(route = Routes.Weapons.route) {
            WeaponsScreen(
                navigateToWeaponDetail = {
                    navController.navigate("${Routes.WeaponsDetail.route}/$it")
                }
            )
        }
        composable(route = "${Routes.WeaponsDetail.route}/{weaponUuid}") {
            WeaponDetailScreen()
        }
        composable(route = Routes.Tiers.route) {
            TiersScreen()
        }
    }
}