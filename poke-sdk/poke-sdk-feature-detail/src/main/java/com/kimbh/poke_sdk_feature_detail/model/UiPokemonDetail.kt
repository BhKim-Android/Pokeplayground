package com.kimbh.poke_sdk_feature_detail.model

import com.kimbh.poke_core_android.model.PokemonType

data class UiPokemonDetail(
    val id: Int,
    val height: Int,
    val weight: Int,
    val image: String,
    val abilities: List<String>,
    val stats: List<Stats>,
    val type: List<PokemonType>
)
