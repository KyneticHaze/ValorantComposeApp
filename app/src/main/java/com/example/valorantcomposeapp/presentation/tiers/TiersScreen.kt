package com.example.valorantcomposeapp.presentation.tiers

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.valorantcomposeapp.common.LoadingBar
import com.example.valorantcomposeapp.common.TextError
import com.example.valorantcomposeapp.domain.model.Tier
import com.example.valorantcomposeapp.presentation.tiers.components.TierItem
import com.example.valorantcomposeapp.presentation.ui.theme.azul
import com.example.valorantcomposeapp.presentation.ui.theme.cupidEye
import com.example.valorantcomposeapp.presentation.ui.theme.valoTertiary
import com.example.valorantcomposeapp.presentation.ui.theme.wildApothecary

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun TiersScreen(
    viewModel: AllTiersViewModel = hiltViewModel()
) {
    val state = viewModel.tierState.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(cupidEye)
    ) {
        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
            items(state.tiers) { tier ->
                TierItem(tier)
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