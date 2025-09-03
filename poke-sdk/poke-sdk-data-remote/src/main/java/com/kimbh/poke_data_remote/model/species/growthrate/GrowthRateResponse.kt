package com.kimbh.poke_data_remote.model.species.growthrate

import com.google.gson.annotations.SerializedName

data class GrowthRateResponse(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)
