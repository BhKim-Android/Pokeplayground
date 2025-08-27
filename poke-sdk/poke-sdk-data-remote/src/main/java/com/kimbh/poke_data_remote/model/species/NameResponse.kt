package com.kimbh.poke_data_remote.model.species

import com.google.gson.annotations.SerializedName

data class NameResponse(
    @SerializedName("language")
    val language: LanguageResponse,

    @SerializedName("name")
    val name: String
)
