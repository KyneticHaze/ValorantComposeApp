package com.example.valorantcomposeapp.presentation.tiers.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import coil.compose.AsyncImage
import com.example.valorantcomposeapp.domain.model.Tier
import com.example.valorantcomposeapp.presentation.ui.theme.cupidEye
import com.example.valorantcomposeapp.presentation.ui.theme.wildApothecary

@Composable
fun TierItem(
    tier: Tier
) {
    Card(
        modifier = Modifier
            .padding(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = wildApothecary
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = tier.tierIcon,
                contentDescription = tier.tierName,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp)
            )
            Text(
                text = tier.tierName.orEmpty(),
                style = TextStyle(
                    color = cupidEye,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    textAlign = TextAlign.Center
                ),
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            )
        }
    }
}