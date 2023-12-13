package com.example.valorantcomposeapp.presentation.maps.all_maps

import com.example.valorantcomposeapp.domain.model.Map

data class MapsState(
    val maps: List<Map> = emptyList(),
    val isLoading: Boolean = false,
    val error : String = ""
)
