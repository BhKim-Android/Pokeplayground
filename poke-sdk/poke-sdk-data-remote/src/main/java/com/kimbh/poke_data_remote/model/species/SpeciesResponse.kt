package com.kimbh.poke_data_remote.model.species

import com.google.gson.annotations.SerializedName

data class SpeciesResponse(
    @SerializedName("color")
    val color: ColorResponse,

    @SerializedName("egg_groups")
    val egg_groups: List<EggGroupResponse>,

    @SerializedName("evolution_chain")
    val evolution_chain: EvolutionChainResponse,

    @SerializedName("names")
    val names: List<NameResponse>
)
