package com.example.valorantcomposeapp.data.dto.weapons


import com.google.gson.annotations.SerializedName

data class GridPosition(
    @SerializedName("column")
    val column: Int,
    @SerializedName("row")
    val row: Int
)