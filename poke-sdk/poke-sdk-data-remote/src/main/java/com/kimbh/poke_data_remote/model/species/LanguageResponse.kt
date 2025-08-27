package com.kimbh.poke_data_remote.model.species

import com.google.gson.annotations.SerializedName

data class LanguageResponse(
    @SerializedName("name")
    val name: String
)
