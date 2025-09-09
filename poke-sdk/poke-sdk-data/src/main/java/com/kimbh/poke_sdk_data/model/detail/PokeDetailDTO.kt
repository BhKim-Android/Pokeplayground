package com.kimbh.poke_sdk_data.model.detail

data class PokeDetailDTO(
    val id: Int,
    val height: Int,
    val weight: Int,
    val stats: List<StatDTO>,
    val type: List<String>,
    val abilities: List<String>,
)