package com.kimbh.poke_data_remote.model.species.genera

import com.google.gson.annotations.SerializedName
import com.kimbh.poke_data_remote.model.species.LanguageResponse

data class GeneraResponse(
    @SerializedName("genus")
    val genus: String,

    @SerializedName("language")
    val language: LanguageResponse
)
