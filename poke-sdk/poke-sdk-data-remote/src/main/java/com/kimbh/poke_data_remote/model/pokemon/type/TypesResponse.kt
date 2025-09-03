package com.kimbh.poke_data_remote.model.pokemon.type

import com.google.gson.annotations.SerializedName

data class TypesResponse(
    @SerializedName("solt")
    val slot: Int,

    @SerializedName("type")
    val type: TypeDetailResponse
)
