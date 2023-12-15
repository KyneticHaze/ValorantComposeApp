package com.example.valorantcomposeapp.presentation.weapons.weaponDetail

import com.example.valorantcomposeapp.domain.model.weapon.Weapon

data class WeaponDetailState(
    val isLoading : Boolean = false,
    val weapon : Weapon? = null,
    val error : String = ""
)
