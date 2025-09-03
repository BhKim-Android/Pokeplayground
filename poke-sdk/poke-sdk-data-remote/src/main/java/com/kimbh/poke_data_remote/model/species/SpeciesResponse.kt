package com.kimbh.poke_data_remote.model.species

import com.google.gson.annotations.SerializedName
import com.kimbh.poke_data_remote.model.species.description.FlavorTextEntryResponse
import com.kimbh.poke_data_remote.model.species.genera.GeneraResponse
import com.kimbh.poke_data_remote.model.species.growthrate.GrowthRateResponse

data class SpeciesResponse(
    @SerializedName("color")
    val color: ColorResponse,

    @SerializedName("egg_groups")
    val egg_groups: List<EggGroupResponse>,

    @SerializedName("evolution_chain")
    val evolution_chain: EvolutionChainResponse,

    @SerializedName("flavor_text_entries")
    val flavor_text_entries: List<FlavorTextEntryResponse>,

    @SerializedName("genera")
    val genera: List<GeneraResponse>,

    @SerializedName("growth_rate")
    val growth_rate: GrowthRateResponse,

    @SerializedName("names")
    val names: List<NameResponse>,

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String
)
