package com.kimbh.poke_sdk_domain.model

data class PokeDetail(
    val id: Int,
    val height: Int,
    val weight: Int,
    val abilities: List<String>,
    val stats: List<StatDetail>,
    val type: List<String>
)
