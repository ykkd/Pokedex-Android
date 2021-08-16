package com.example.model

import com.example.response.TypeResponse

data class Type(
    val slot: Int,
    val type: TypeX
) {

    companion object {
        fun transform(typeResponse: TypeResponse): Type {
            return Type(
                slot = typeResponse.slot,
                type = TypeX.transform(typeResponse.type)
            )
        }
    }
}