package com.example.valorantcomposeapp.data.dto.tiers


import com.google.gson.annotations.SerializedName

data class TierResponse(
    @SerializedName("data")
    val data: List<CompetitiveTier>?,
    @SerializedName("status")
    val status: Int?
)