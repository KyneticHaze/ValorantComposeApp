package com.example.valorantcomposeapp.domain.model

import com.example.valorantcomposeapp.data.dto.agents.Ability
import com.example.valorantcomposeapp.data.dto.agents.Role

data class Agent(
    val abilities : List<Ability>,
    val description : String,
    val displayIcon : String,
    val displayName : String,
    val portrait : String,
    val role : Role?,
    val uuid : String
)