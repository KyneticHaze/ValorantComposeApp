package com.example.valorantcomposeapp.presentation.tiers

import com.example.valorantcomposeapp.domain.model.Tier

data class TierState(
    val isLoading : Boolean = false,
    val tiers : List<Tier> = emptyList(),
    val error : String = ""
)
