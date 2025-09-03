package com.kimbh.poke_data_remote.model.species.description

import com.google.gson.annotations.SerializedName
import com.kimbh.poke_data_remote.model.species.LanguageResponse

data class FlavorTextEntryResponse(
    @SerializedName("flavor_text")
    val flavor_text: String,

    @SerializedName("language")
    val language: LanguageResponse
)
