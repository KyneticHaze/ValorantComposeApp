package com.example.valorantcomposeapp.presentation

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.valorantcomposeapp.common.Routes
import com.example.valorantcomposeapp.presentation.agents.all_agents.AgentsScreen
import com.example.valorantcomposeapp.navigation.MainNavigationBar
import com.example.valorantcomposeapp.navigation.NavGraphComponent

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun ValorantApp() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            MainNavigationBar(navController)
        }
    ) { paddingValues ->
        NavGraphComponent(navController = navController, paddingValues)
    }
}