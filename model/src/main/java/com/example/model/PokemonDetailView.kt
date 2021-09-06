package com.example.model

import com.example.response.AbilityResponse
import com.example.response.PokemonDetailResponse
import com.example.response.TypeResponse

data class PokemonDetailView(
    val id: Int,
    val name: String,
    val height: Float,
    val weight: Float,
    val type1: Type,
    val type2: Type?,
    val ability1: Ability,
    val ability2: Ability?,
    val hiddenAbility: Ability?,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val special_attack: Int,
    val special_defense: Int,
    val speed: Int
) {

    companion object {
        fun transform(pokemonDetailResponse: PokemonDetailResponse): PokemonDetailView {
            return PokemonDetailView(
                id = pokemonDetailResponse.id,
                name = pokemonDetailResponse.name ?: "",
                height = pokemonDetailResponse.height,
                weight = pokemonDetailResponse.weight,
                type1 = Type.transform(pokemonDetailResponse.types[0]),
                type2 = pokemonDetailResponse.types.getOrNull(1)?.let { Type.transform(it) },
                ability1 = Ability.transform(pokemonDetailResponse.abilities[0]),
                ability2 = pokemonDetailResponse.abilities.getOrNull(1)
                    ?.let { Ability.transform(it) },
                hiddenAbility = pokemonDetailResponse.abilities.find { it.is_hidden }
                    ?.let { Ability.transform(it) },
                hp = pokemonDetailResponse.hp?.base_stat ?: 0,
                attack = pokemonDetailResponse.attack?.base_stat ?: 0,
                defense = pokemonDetailResponse.defense?.base_stat ?: 0,
                special_attack = pokemonDetailResponse.specialAttack?.base_stat ?: 0,
                special_defense = pokemonDetailResponse.specialDefense?.base_stat ?: 0,
                speed = pokemonDetailResponse.speed?.base_stat ?: 0
            )
        }
    }
}