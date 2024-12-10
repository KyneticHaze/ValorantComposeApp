package com.example.valorantcomposeapp.presentation.weapons.weaponDetail

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.valorantcomposeapp.common.StatsBar
import com.example.valorantcomposeapp.presentation.ui.theme.azul
import com.example.valorantcomposeapp.presentation.ui.theme.cupidEye
import com.example.valorantcomposeapp.presentation.ui.theme.radiant
import com.example.valorantcomposeapp.presentation.ui.theme.wildApothecary
import com.example.valorantcomposeapp.presentation.weapons.weaponDetail.components.SkinBox

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun WeaponDetailScreen(
    viewModel: WeaponDetailViewModel = hiltViewModel()
) {
    val state = viewModel.weaponState.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(cupidEye)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        state.weapon?.let { weapon ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = wildApothecary, shape = RoundedCornerShape(
                            bottomStart = 32.dp, bottomEnd = 32.dp
                        )
                    ), contentAlignment = Alignment.Center
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = weapon.displayIcon,
                        contentDescription = weapon.displayName,
                        modifier = Modifier.size(300.dp),
                        alignment = Alignment.Center
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp)
                    ) {
                        Column {
                            Text(
                                text = weapon.displayName.orEmpty(),
                                style = MaterialTheme.typography.headlineLarge,
                                color = cupidEye
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = weapon.category.orEmpty()
                                    .replace("EEquippableCategory::", ""),
                                style = MaterialTheme.typography.headlineSmall,
                                color = cupidEye
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Cost", style = MaterialTheme.typography.headlineLarge,
                                color = cupidEye
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = "${weapon.weaponMarket?.cost.toString()}$",
                                style = MaterialTheme.typography.headlineSmall,
                                color = cupidEye
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
            Spacer(modifier = Modifier.size(24.dp))
            Text(
                text = "Weapon Stats",
                style = MaterialTheme.typography.headlineLarge,
                color = azul
            )
            Spacer(modifier = Modifier.size(16.dp))

            weapon.weaponStats?.damageRanges?.getOrNull(0)?.let { damageRange ->
                Column(
                    modifier = Modifier.padding(start = 24.dp, end = 24.dp)
                ) {
                    damageRange.headDamage?.div(200)?.let { d ->
                        StatsBar(
                            title = "Head Damage",
                            progress = d.toFloat(),
                            progressName = damageRange.bodyDamage.toString()
                        )
                    }
                    damageRange.bodyDamage?.toFloat()?.div(200)?.let { d ->
                        StatsBar(
                            title = "Body Damage",
                            progress = d,
                            progressName = damageRange.bodyDamage.toString()
                        )
                    }
                    damageRange.legDamage?.div(200)?.let { d ->
                        StatsBar(
                            title = "Leg Damage",
                            progress = d.toFloat(),
                            progressName = damageRange.legDamage.toString()
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "Skins", style = MaterialTheme.typography.headlineLarge, color = azul)
            Spacer(modifier = Modifier.size(16.dp))
            SkinBox(weapon.skins.orEmpty())
        }
    }
}