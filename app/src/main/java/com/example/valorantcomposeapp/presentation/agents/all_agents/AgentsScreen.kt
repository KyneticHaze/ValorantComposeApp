package com.example.valorantcomposeapp.presentation.agents.all_agents

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.valorantcomposeapp.common.LoadingBar
import com.example.valorantcomposeapp.common.TextError
import com.example.valorantcomposeapp.presentation.agents.all_agents.components.AgentItem
import com.example.valorantcomposeapp.presentation.ui.theme.cupidEye

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun AgentsScreen(
    viewmodel: AgentsViewModel = hiltViewModel(),
    navigateToAgentDetail: (String) -> Unit
) {
    val state = viewmodel.state.value

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 12.dp)
                .background(cupidEye)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(12.dp)
            ) {
                items(state.agents) { agentItem ->
                    AgentItem(
                        agent = agentItem,
                        navigate = { navigateToAgentDetail.invoke(it) }
                    )
                }
            }
        }


        if (state.error.isNotBlank()) {
            TextError(error = state.error)
        }

        if (state.isLoading) {
            LoadingBar()
        }
    }
}