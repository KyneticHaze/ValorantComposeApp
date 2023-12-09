package com.example.valorantcomposeapp.data.mapper

import com.example.valorantcomposeapp.data.remote.Ability
import com.example.valorantcomposeapp.data.remote.Agent
import com.example.valorantcomposeapp.domain.model.ModelAbility
import com.example.valorantcomposeapp.domain.model.ModelAgent

fun Agent.toModelAgent() : ModelAgent {
    return ModelAgent(
        displayName = displayName,
        description = description,
        displayIcon = displayIcon,
        portrait = fullPortrait,
        abilities = abilities.map { it.toModelAbility() }
    )
}

fun Ability.toModelAbility() : ModelAbility {
    return ModelAbility(
        abilityNum = slot,
        abilityName = displayName,
        abilityDesc = description,
        abilityIcon = displayIcon
    )
}