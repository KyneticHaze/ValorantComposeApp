package com.example.valorantcomposeapp.presentation.maps.map_detail

import com.example.valorantcomposeapp.domain.model.Map

data class MapDetailState(
    val isLoading : Boolean = false,
    val mapDetail : Map? = null,
    val error : String = ""
)
