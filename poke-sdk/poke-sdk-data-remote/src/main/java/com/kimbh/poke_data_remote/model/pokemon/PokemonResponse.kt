package com.kimbh.poke_data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("abilities")
    val abilities: List<AbilitiesResponse>,

    @SerializedName("base_experience")
    val base_experience: Int,

    @SerializedName("sprites")
    val sprites: List<SprityResponse>
)
