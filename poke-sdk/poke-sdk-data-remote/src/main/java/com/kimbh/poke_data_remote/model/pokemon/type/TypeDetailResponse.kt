package com.kimbh.poke_data_remote.model.pokemon.type

import com.google.gson.annotations.SerializedName

data class TypeDetailResponse(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)