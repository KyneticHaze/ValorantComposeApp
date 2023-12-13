package com.example.valorantcomposeapp.presentation.maps.all_maps

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.valorantcomposeapp.domain.model.Map
import com.example.valorantcomposeapp.presentation.ui.theme.cupidEye

@Composable
fun MapItem(
    map: Map,
    onItemClick: (String) -> Unit
) {
    Box(modifier = Modifier
        .size(width = 350.dp, height = 250.dp)
        .clickable {
            onItemClick(map.uuid.orEmpty())
        }
    ) {
        AsyncImage(
            model = map.mapImage,
            contentDescription = map.description,
            contentScale = ContentScale.Crop
        )
        Text(
            text = map.displayName.orEmpty(), style = TextStyle(
                color = cupidEye,
                fontSize = 20.sp,
                fontWeight = FontWeight.W500,
                textAlign = TextAlign.Center
            ), overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        colors = colors
                    )
                )
                .fillMaxWidth()
                .padding(6.dp)
        )
    }
}

val colors = listOf<Color>(
    Color.Transparent,
    Color.Gray
)