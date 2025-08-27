package com.kimbh.poke_data_remote.model.species

import com.google.gson.annotations.SerializedName

data class EggGroupResponse(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)
