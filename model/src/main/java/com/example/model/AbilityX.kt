package com.example.model

import com.example.response.AbilityXResponse

data class AbilityX (
    val name: String,
    val url: String
) {

    companion object {
        fun transform(abilityXResponse: AbilityXResponse): AbilityX {
            return AbilityX(
                name = abilityXResponse.name,
                url = abilityXResponse.url
            )
        }
    }
}