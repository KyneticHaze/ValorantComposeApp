package com.example.valorantcomposeapp.domain.model

data class Agent(
    val displayName : String,
    val description : String,
    val displayIcon : String,
    val portrait : String,
    val abilities : List<Ability>
)