package com.example.valorantcomposeapp.data.dto.tiers


import com.google.gson.annotations.SerializedName

data class CompetitiveTier(
    @SerializedName("assetObjectName")
    val assetObjectName: String?,
    @SerializedName("assetPath")
    val assetPath: String?,
    @SerializedName("tiers")
    val tiers: List<TierDTO>?,
    @SerializedName("uuid")
    val uuid: String?
)