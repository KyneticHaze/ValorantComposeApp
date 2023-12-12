package com.example.valorantcomposeapp.data.dto.agents


import com.google.gson.annotations.SerializedName

data class AgentsResponse(
    @SerializedName("data")
    val data: List<AgentDTO>?,
    @SerializedName("status")
    val status: Int?
)