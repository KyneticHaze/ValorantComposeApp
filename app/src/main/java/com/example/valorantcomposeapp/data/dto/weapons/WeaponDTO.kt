package com.example.valorantcomposeapp.data.dto.weapons


import com.example.valorantcomposeapp.domain.model.weapon.Weapon
import com.google.gson.annotations.SerializedName

data class WeaponDTO(
    @SerializedName("assetPath")
    val assetPath: String?,
    @SerializedName("category")
    val category: String?,
    @SerializedName("defaultSkinUuid")
    val defaultSkinUuid: String?,
    @SerializedName("displayIcon")
    val displayIcon: String?,
    @SerializedName("displayName")
    val displayName: String?,
    @SerializedName("killStreamIcon")
    val killStreamIcon: String?,
    @SerializedName("shopData")
    val shopData: ShopData?,
    @SerializedName("skins")
    val skins: List<Skin>?,
    @SerializedName("uuid")
    val uuid: String?,
    @SerializedName("weaponStats")
    val weaponStats: WeaponStats?
)

fun WeaponDTO.toWeapon() : Weapon = Weapon(
    displayName = displayName,
    displayIcon = displayIcon,
    weaponMarket = shopData,
    skins = skins,
    weaponUuid = uuid
)