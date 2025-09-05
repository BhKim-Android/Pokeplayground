package com.kimbh.poke_sdk_domain.model

data class PokeDetail(
    val id: Int,
    val height: Int,
    val weight: Int,
    val type: List<String>
)
