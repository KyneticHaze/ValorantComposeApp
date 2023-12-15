package com.example.valorantcomposeapp.presentation.maps.all_maps

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.valorantcomposeapp.common.LoadingBar
import com.example.valorantcomposeapp.common.TextError
import com.example.valorantcomposeapp.presentation.ui.theme.cupidEye

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun MapsScreen(
    viewModel: MapsViewModel = hiltViewModel(),
    navigateToMapDetail: (String) -> Unit
) {

    val state = viewModel.mapsState.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(cupidEye),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(state.maps) { map ->
                MapItem(map = map, onItemClick = {
                    navigateToMapDetail(it)
                })
            }
        }

        if (state.isLoading) {
            LoadingBar()
        }

        if (state.error.isNotBlank()) {
            TextError(error = state.error)
        }
    }
}