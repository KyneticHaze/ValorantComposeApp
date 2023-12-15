package com.example.valorantcomposeapp.common

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.valorantcomposeapp.presentation.ui.theme.azul
import com.example.valorantcomposeapp.presentation.ui.theme.cupidEye
import com.example.valorantcomposeapp.presentation.ui.theme.wildApothecary

@Composable
fun StatsBar(
    title: String,
    progress: Float,
    progressName: String
) {
    val statsState = animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec,
        label = "Stats Value"
    ).value

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$title - $progressName",
            style = MaterialTheme.typography.headlineSmall,
            color = wildApothecary,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(5.dp))
        LinearProgressIndicator(
            progress = statsState,
            modifier = Modifier.height(12.dp),
            color = wildApothecary,
            trackColor = cupidEye
        )
    }
}