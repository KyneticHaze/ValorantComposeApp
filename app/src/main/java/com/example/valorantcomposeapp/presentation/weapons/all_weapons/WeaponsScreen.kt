package com.example.valorantcomposeapp.presentation.weapons.all_weapons

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.valorantcomposeapp.common.LoadingBar
import com.example.valorantcomposeapp.common.TextError
import com.example.valorantcomposeapp.presentation.ui.theme.azul
import com.example.valorantcomposeapp.presentation.ui.theme.cupidEye
import com.example.valorantcomposeapp.presentation.ui.theme.valoTertiary
import com.example.valorantcomposeapp.presentation.weapons.all_weapons.components.WeaponItem

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun WeaponsScreen(
    viewModel: WeaponsViewModel = hiltViewModel(),
    navigateToWeaponDetail: (String) -> Unit
) {

    val state = viewModel.weaponState.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(cupidEye)
    ) {
        Box {
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(state.weapons) { weapon ->
                    WeaponItem(weapon = weapon) {
                        navigateToWeaponDetail(it)
                    }
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
}