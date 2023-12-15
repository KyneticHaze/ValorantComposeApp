package com.example.valorantcomposeapp.data.dto.tiers


import com.example.valorantcomposeapp.domain.model.Tier
import com.google.gson.annotations.SerializedName

data class TierDTO(
    @SerializedName("backgroundColor")
    val backgroundColor: String?,
    @SerializedName("color")
    val color: String?,
    @SerializedName("division")
    val division: String?,
    @SerializedName("divisionName")
    val divisionName: String?,
    @SerializedName("largeIcon")
    val largeIcon: String?,
    @SerializedName("rankTriangleDownIcon")
    val rankTriangleDownIcon: String?,
    @SerializedName("rankTriangleUpIcon")
    val rankTriangleUpIcon: String?,
    @SerializedName("smallIcon")
    val smallIcon: String?,
    @SerializedName("tier")
    val tier: Int?,
    @SerializedName("tierName")
    val tierName: String?
)

fun TierDTO.toTier() : Tier = Tier(
    tierName = tierName,
    tierIcon = largeIcon
)