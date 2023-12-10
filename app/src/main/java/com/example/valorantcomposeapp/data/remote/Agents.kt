package com.example.valorantcomposeapp.data.remote


import com.google.gson.annotations.SerializedName

data class Agents(
    @SerializedName("data")
    val `data`: List<Agent>,
    @SerializedName("status")
    val status: Int
)