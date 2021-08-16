package com.example.model

import com.example.response.AbilityResponse
import com.example.response.TypeResponse

data class PokemonDetailView(
    val id: Int,
    val name: String,
    val height: Float,
    val weight: Float,
    val type1: TypeResponse,
    val type2: TypeResponse?,
    val ability1: AbilityResponse,
    val ability2: AbilityResponse?,
    val hiddenAbility: AbilityResponse?,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val special_attack: Int,
    val special_defense: Int,
    val speed: Int
) {

}