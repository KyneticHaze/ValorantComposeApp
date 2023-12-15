package com.example.valorantcomposeapp.presentation.weapons.all_weapons

import com.example.valorantcomposeapp.domain.model.weapon.Weapon

data class WeaponsState(
    val isLoading: Boolean = false,
    val weapons : List<Weapon> = emptyList(),
    val error: String = ""
)
