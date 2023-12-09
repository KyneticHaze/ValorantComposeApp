package com.example.valorantcomposeapp.data.remote


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AgentsDTO(
    @Json(name = "data")
    val `data`: List<Agent>,
    @Json(name = "status")
    val status: Int
)