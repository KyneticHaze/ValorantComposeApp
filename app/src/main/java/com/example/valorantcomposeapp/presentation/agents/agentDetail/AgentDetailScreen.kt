package com.example.valorantcomposeapp.presentation.agents.agentDetail

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.valorantcomposeapp.presentation.agents.agentDetail.components.AgentAbilityItem
import com.example.valorantcomposeapp.presentation.ui.theme.cupidEye
import com.example.valorantcomposeapp.presentation.ui.theme.radiant
import com.example.valorantcomposeapp.presentation.ui.theme.wildApothecary

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun AgentDetailScreen(
    viewModel: AgentDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.agentState.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(cupidEye)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        state.agent?.let { agent ->
            Box(
                modifier = Modifier
                    .background(
                        color = wildApothecary,
                        shape = RoundedCornerShape(
                            bottomStart = 32.dp,
                            bottomEnd = 32.dp
                        )
                    )
                    .padding(24.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    modifier = Modifier.size(400.dp),
                    model = agent.role?.displayIcon,
                    contentDescription = agent.description,
                    alpha = 0.2f,
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
                    Text(
                        text = agent.displayName,
                        style = MaterialTheme.typography.headlineMedium,
                        color = cupidEye
                    )
                    Spacer(modifier = Modifier.size(12.dp))
                    Text(
                        text = agent.role?.displayName.orEmpty(),
                        style = MaterialTheme.typography.headlineSmall,
                        color = cupidEye
                    )
                    Spacer(modifier = Modifier.size(15.dp))
                }
            }
            Spacer(modifier = Modifier.size(24.dp))
            Text(
                text = "Description",
                style = MaterialTheme.typography.headlineMedium,
                color = radiant
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = agent.description,
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    color = wildApothecary,
                    fontSize = 16.5.sp,
                    fontWeight = FontWeight.W500
                ),
                modifier = Modifier.padding(start = 24.dp, end = 24.dp)
            )
            Spacer(modifier = Modifier.size(24.dp))
            Text(text = "Abilities", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.size(10.dp))
            
            AgentAbilityItem(abilities = agent.abilities)
        }
    }
}

