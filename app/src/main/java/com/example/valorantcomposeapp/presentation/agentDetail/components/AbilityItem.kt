package com.example.valorantcomposeapp.presentation.agentDetail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.valorantcomposeapp.data.remote.Ability
import com.example.valorantcomposeapp.presentation.ui.theme.cupidEye
import com.example.valorantcomposeapp.presentation.ui.theme.wildApothecary

@Composable
fun AbilityItem(
    ability: Ability
) {
    Card {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(wildApothecary)
                .padding(8.dp)
        ) {
            AsyncImage(
                model = ability.displayIcon,
                contentDescription = ability.description,
                modifier = Modifier.size(60.dp)
            )
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(
                    text = ability.displayName ?: "",
                    style = TextStyle(
                        textAlign = TextAlign.Start,
                        color = cupidEye,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.W500
                    ),
                    color = cupidEye
                )
                Text(
                    text = ability.description ?: "",
                    style = TextStyle(
                        textAlign = TextAlign.Start,
                        color = cupidEye,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400
                    )
                )
            }
        }
    }
}