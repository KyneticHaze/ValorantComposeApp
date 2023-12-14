package com.example.valorantcomposeapp.data.dto.weapons


import com.google.gson.annotations.SerializedName

data class WeaponResponse(
    @SerializedName("data")
    val data: List<WeaponDTO>?,
    @SerializedName("status")
    val status: Int?
)