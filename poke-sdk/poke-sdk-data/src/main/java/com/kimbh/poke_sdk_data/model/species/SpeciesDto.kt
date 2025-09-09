package com.kimbh.poke_sdk_data.model.species

data class SpeciesDto(
    val id: Int,
    val name: String,
    val gender_rate: Int,
    val flavor_text_entries: List<FlavorTextDTO>,
    val egg_groups: List<String>,
    val genera: List<GeneraDTO>
)