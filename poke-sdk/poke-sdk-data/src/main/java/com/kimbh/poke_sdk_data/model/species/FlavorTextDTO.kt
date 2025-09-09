package com.kimbh.poke_sdk_data.model.species

import com.kimbh.poke_sdk_data.model.LanguageDTO

data class FlavorTextDTO(
    val flavor_text: String,
    val language: LanguageDTO
)