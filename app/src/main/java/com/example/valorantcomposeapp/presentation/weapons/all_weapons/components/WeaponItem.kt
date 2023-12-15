package com.example.valorantcomposeapp.presentation.weapons.all_weapons.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.valorantcomposeapp.domain.model.weapon.Weapon
import com.example.valorantcomposeapp.presentation.ui.theme.azul
import com.example.valorantcomposeapp.presentation.ui.theme.cupidEye
import com.example.valorantcomposeapp.presentation.ui.theme.wildApothecary

@Composable
fun WeaponItem(
    weapon: Weapon,
    onItemClick: (String) -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = wildApothecary,
            contentColor = azul
        ),
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                onItemClick(weapon.weaponUuid.orEmpty())
            },
        shape = RoundedCornerShape(10.dp)
    ) {
        AsyncImage(
            model = weapon.displayIcon,
            contentDescription = weapon.displayName,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(200.dp),
            alignment = Alignment.Center
        )
        Text(
            text = weapon.displayName.orEmpty(),
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.W500,
                textAlign = TextAlign.Center,
                color = cupidEye
            ),
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )
    }
}