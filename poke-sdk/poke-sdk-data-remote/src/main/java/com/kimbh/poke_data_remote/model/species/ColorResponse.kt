package com.kimbh.poke_data_remote.model.species

import com.google.gson.annotations.SerializedName

data class ColorResponse(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)
