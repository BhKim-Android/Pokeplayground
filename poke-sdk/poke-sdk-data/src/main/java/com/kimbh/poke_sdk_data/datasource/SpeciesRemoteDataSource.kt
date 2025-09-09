package com.kimbh.poke_sdk_data.datasource

import com.kimbh.poke_sdk_core.result.CoreResult
import com.kimbh.poke_sdk_data.model.species.SpeciesDto

interface SpeciesRemoteDataSource {
    suspend fun getSpecies(id: Int): CoreResult<SpeciesDto>
}