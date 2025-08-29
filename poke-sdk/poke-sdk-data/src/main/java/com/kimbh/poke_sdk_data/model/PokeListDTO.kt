package com.kimbh.poke_sdk_data.model

import com.kimbh.poke_sdk_domain.model.Pokemon

data class PokeListDTO(
    val name: String,
    val url: String
)

fun PokeListDTO.toDomain(): Pokemon {
    return Pokemon(
        name = this.name,
        url = url
    )
}
