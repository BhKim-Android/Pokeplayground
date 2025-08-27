package com.kimbh.poke_data_remote.model.pokelist

import com.google.gson.annotations.SerializedName

data class ResultResponse(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)
