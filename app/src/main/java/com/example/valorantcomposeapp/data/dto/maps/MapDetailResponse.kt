package com.example.valorantcomposeapp.data.dto.maps

import com.google.gson.annotations.SerializedName

data class MapDetailResponse(
    @SerializedName("data")
    val data: MapDTO?,
    @SerializedName("status")
    val status: Int?
)
