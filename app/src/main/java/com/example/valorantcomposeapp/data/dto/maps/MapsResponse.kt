package com.example.valorantcomposeapp.data.dto.maps


import com.google.gson.annotations.SerializedName

data class MapsResponse(
    @SerializedName("data")
    val data: List<MapDTO>?,
    @SerializedName("status")
    val status: Int?
)