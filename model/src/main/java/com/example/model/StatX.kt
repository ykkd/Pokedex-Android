package com.example.model

import com.example.response.StatResponse
import com.example.response.StatXResponse

data class StatX(
    val name: String,
    val url: String
) {

    companion object {
        fun transform(statXResponse: StatXResponse): StatX {
            return StatX(
                name = statXResponse.name,
                url = statXResponse.url
            )
        }
    }
}