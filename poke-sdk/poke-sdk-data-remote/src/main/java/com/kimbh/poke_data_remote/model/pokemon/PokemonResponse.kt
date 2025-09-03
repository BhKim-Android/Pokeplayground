package com.kimbh.poke_data_remote.model.pokemon

import com.google.gson.annotations.SerializedName
import com.kimbh.poke_data_remote.model.pokemon.ability.AbilitiesResponse
import com.kimbh.poke_data_remote.model.pokemon.form.FormResponse
import com.kimbh.poke_data_remote.model.pokemon.stat.StateResponse
import com.kimbh.poke_data_remote.model.pokemon.type.TypesResponse

data class PokemonResponse(
    @SerializedName("abilities")
    val abilities: List<AbilitiesResponse>,

    @SerializedName("base_experience")
    val base_experience: Int,

    @SerializedName("sprites")
    val sprites: List<SprityResponse>,

    @SerializedName("forms")
    val forms: List<FormResponse>,

    @SerializedName("height")
    val height: Int,

    @SerializedName("id")
    val id: Int,

    @SerializedName("weight")
    val weight: Int,

    @SerializedName("stats")
    val stats: List<StateResponse>,

    @SerializedName("types")
    val types: List<TypesResponse>
)
