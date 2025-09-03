package com.kimbh.poke_data_remote.model.pokemon.ability

import com.google.gson.annotations.SerializedName

data class AbilityResponse(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)
