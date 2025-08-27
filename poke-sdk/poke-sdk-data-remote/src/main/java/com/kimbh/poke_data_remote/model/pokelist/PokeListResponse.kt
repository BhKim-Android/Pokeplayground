package com.kimbh.poke_data_remote.model.pokelist

import com.google.gson.annotations.SerializedName

data class PokeListResponse(
    @SerializedName("count")
    val count: Int,

    @SerializedName("next")
    val next: String,

    @SerializedName("previous")
    val previous: String,

    @SerializedName("results")
    val results: List<ResultResponse>
)