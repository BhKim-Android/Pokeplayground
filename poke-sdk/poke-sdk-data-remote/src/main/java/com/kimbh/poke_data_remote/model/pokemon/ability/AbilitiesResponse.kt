package com.kimbh.poke_data_remote.model.pokemon.ability

import com.google.gson.annotations.SerializedName

data class AbilitiesResponse(
    @SerializedName("ability")
    val ability: AbilityResponse,

    @SerializedName("is_hidden")
    val is_hidden: Boolean,

    @SerializedName("slot")
    val slot: Int
)
