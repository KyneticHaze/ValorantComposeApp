package com.example.valorantcomposeapp.domain.model.weapon

import com.example.valorantcomposeapp.data.dto.weapons.ShopData
import com.example.valorantcomposeapp.data.dto.weapons.Skin
import com.example.valorantcomposeapp.data.dto.weapons.WeaponStats

data class Weapon(
    val displayName : String?,
    val displayIcon : String?,
    val weaponMarket : ShopData?,
    val weaponStats : WeaponStats?,
    val skins : List<Skin>?,
    val category : String?,
    val weaponUuid : String?
)
