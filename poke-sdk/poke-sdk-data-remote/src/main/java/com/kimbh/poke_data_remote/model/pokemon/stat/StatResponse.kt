package com.kimbh.poke_data_remote.model.pokemon.stat

import com.google.gson.annotations.SerializedName

data class StatResponse(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)
