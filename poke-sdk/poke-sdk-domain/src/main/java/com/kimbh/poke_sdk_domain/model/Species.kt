package com.kimbh.poke_sdk_domain.model

data class Species(
    val id: Int,
    val name: String,
    val flavor_text: String,
    val gender_rate: Int,
    val egg_groups: List<String>,
    val genera: String
)
