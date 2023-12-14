package com.example.valorantcomposeapp.data.dto.weapons


import com.google.gson.annotations.SerializedName

data class AirBurstStats(
    @SerializedName("burstDistance")
    val burstDistance: Double,
    @SerializedName("shotgunPelletCount")
    val shotgunPelletCount: Int
)