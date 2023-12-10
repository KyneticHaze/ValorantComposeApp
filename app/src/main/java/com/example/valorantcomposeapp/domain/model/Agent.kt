package com.example.valorantcomposeapp.domain.model

import com.example.valorantcomposeapp.data.remote.Ability
import com.example.valorantcomposeapp.data.remote.Role

data class Agent(
    val abilities : List<Ability>,
    val description : String,
    val displayIcon : String,
    val displayName : String,
    val portrait : String,
    val role : Role?,
    val uuid : String
)