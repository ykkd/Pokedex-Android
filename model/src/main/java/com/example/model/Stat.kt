package com.example.model

import com.example.response.StatResponse
import com.example.response.StatXResponse

data class Stat(
    val baseStat: Int,
    val effort: Int,
    val stat: StatXResponse
) {

    companion object {
        fun transform(statResponse: StatResponse): Stat {
            return Stat(
                baseStat = statResponse.base_stat,
                effort = statResponse.effort,
                stat = StatX.transform(statResponse.stat)
            )
        }
    }
}