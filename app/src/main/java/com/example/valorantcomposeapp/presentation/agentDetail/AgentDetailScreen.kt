package com.example.valorantcomposeapp.presentation.agentDetail

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.valorantcomposeapp.data.remote.Ability

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun AgentDetailScreen(

    viewModel: AgentDetailViewModel = hiltViewModel()
) {
    val state = viewModel.agentState.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        state.agent?.let { agent ->
            Box(
                modifier = Modifier.background(
                    color = Color.Red,
                    shape = RoundedCornerShape(
                        bottomStart = 32.dp,
                        bottomEnd = 32.dp
                    )
                ), contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = agent.role?.displayIcon,
                    contentDescription = agent.description,
                    alpha = 0.2f
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = agent.portrait,
                        contentDescription = agent.description,
                        modifier = Modifier.size(300.dp)
                    )
                    Spacer(modifier = Modifier.size(24.dp))
                    Text(text = agent.displayName, style = MaterialTheme.typography.headlineMedium)
                    Spacer(modifier = Modifier.size(12.dp))
                    Text(
                        text = agent.role?.displayName.orEmpty(),
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
            Spacer(modifier = Modifier.size(24.dp))
            Text(text = "Description", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = agent.description,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = Color.Red,
                modifier = Modifier.padding(start = 24.dp, end = 24.dp)
            )
            Spacer(modifier = Modifier.size(24.dp))
            Text(text = "Abilities", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.size(6.dp))
            LazyRow {
                items(agent.abilities.size) {
                    AbilityItem(ability = agent.abilities[it])
                }
            }
        }
    }
}

@Composable
fun AbilityItem(
    ability: Ability
) {

    var selectedItemIndex by remember {
        mutableIntStateOf(0)
    }

    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(RoundedCornerShape(15.dp)),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(model = ability.displayIcon, contentDescription = ability.description)

    }
}