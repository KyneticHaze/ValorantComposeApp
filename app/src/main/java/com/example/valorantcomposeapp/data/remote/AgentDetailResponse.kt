package com.example.valorantcomposeapp.data.remote

import com.google.gson.annotations.SerializedName

data class AgentDetailResponse(
    @SerializedName("data")
    val data: AgentDTO?,
    @SerializedName("status")
    val status: Int?
)
