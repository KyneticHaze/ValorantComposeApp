package com.example.valorantcomposeapp.data.remote


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecruitmentData(
    @Json(name = "counterId")
    val counterId: String,
    @Json(name = "endDate")
    val endDate: String,
    @Json(name = "levelVpCostOverride")
    val levelVpCostOverride: Int,
    @Json(name = "milestoneId")
    val milestoneId: String,
    @Json(name = "milestoneThreshold")
    val milestoneThreshold: Int,
    @Json(name = "startDate")
    val startDate: String,
    @Json(name = "useLevelVpCostOverride")
    val useLevelVpCostOverride: Boolean
)