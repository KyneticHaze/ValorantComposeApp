package com.example.valorantcomposeapp.presentation.maps.map_detail

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.valorantcomposeapp.common.LoadingBar
import com.example.valorantcomposeapp.common.TextError
import com.example.valorantcomposeapp.presentation.ui.theme.azul
import com.example.valorantcomposeapp.presentation.ui.theme.cupidEye
import com.example.valorantcomposeapp.presentation.ui.theme.radiant

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun MapDetailScreen(
    viewModel: MapDetailViewModel = hiltViewModel()
) {
    val state = viewModel.mapDetailState.value


    Column(modifier = Modifier
        .fillMaxSize()
        .background(radiant.copy(0.2f))
        .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        state.mapDetail?.let { map ->
            AsyncImage(
                model = map.displayLittleMap,
                contentDescription = map.description,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(width = 250.dp, height = 150.dp)
            )
            Text(
                text = map.displayName.orEmpty(), style = TextStyle(
                    color = azul,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
            )
            Text(
                text = map.description.orEmpty(), style = TextStyle(
                    color = cupidEye,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    textAlign = TextAlign.Justify
                )
            )
            AsyncImage(
                model = map.displayMap,
                contentDescription = map.description,
                modifier = Modifier.size(300.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = map.coordinates.orEmpty(), style = TextStyle(
                    color = cupidEye,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    textAlign = TextAlign.Center
                )
            )
        }
        if (state.error.isNotBlank()) {
            TextError(error = state.error)
        }

        if (state.isLoading) {
            LoadingBar()
        }
    }
}