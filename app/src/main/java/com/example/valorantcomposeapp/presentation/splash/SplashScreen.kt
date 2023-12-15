package com.example.valorantcomposeapp.presentation.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToAgents: () -> Unit
) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnimation =
        animateFloatAsState(
            targetValue = if (startAnimation) 1f else 0f,
            animationSpec = tween(durationMillis = 2000),
            label = "Splash Screen Animation"
        )
    
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(2000)
        navigateToAgents()
    }

    SplashDesign(alpha = alphaAnimation.value)
}