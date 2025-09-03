package com.kimbh.poke_data_remote.model.pokemon.stat

import com.google.gson.annotations.SerializedName

data class StateResponse(
    @SerializedName("base_stat")
    val base_stat: Int,

    @SerializedName("effort")
    val effort: Int,

    @SerializedName("stat")
    val stat: StatResponse
)
