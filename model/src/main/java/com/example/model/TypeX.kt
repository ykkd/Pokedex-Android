package com.example.model

import com.example.response.TypeXResponse

data class TypeX(
    val name: String,
    val url: String
) {

    companion object {
        fun transform(typeXResponse: TypeXResponse): TypeX {
            return TypeX(
                name = typeXResponse.name,
                url = typeXResponse.url
            )
        }
    }
}