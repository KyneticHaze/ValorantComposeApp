package com.example.valorantcomposeapp.data.dto.weapons

import com.google.gson.annotations.SerializedName

data class WeaponDetailResponse(
    @SerializedName("data")
    val data: WeaponDTO?,
    @SerializedName("status")
    val status: Int?
)
