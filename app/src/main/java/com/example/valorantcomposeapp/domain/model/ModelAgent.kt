package com.example.valorantcomposeapp.domain.model

data class ModelAgent(
    val displayName : String,
    val description : String,
    val displayIcon : String,
    val portrait : String,
    val role : ModelRole,
    val abilities : List<ModelAbility>
)