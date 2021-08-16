package com.example.model

import com.example.response.AbilityResponse
import com.example.response.AbilityXResponse

data class Ability(
    val abilityX: AbilityX,
    val isHidden: Boolean,
    val slot: Int
) {

    companion object {
        fun transform(abilityResponse: AbilityResponse): Ability {
            return Ability(
                abilityX = AbilityX.transform(abilityResponse.ability),
                isHidden = abilityResponse.is_hidden,
                slot = abilityResponse.slot
            )
        }
    }
}