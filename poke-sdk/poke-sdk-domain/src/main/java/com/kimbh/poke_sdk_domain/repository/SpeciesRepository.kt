package com.kimbh.poke_sdk_domain.repository

import com.kimbh.poke_sdk_core.result.CoreResult
import com.kimbh.poke_sdk_domain.model.Species

interface SpeciesRepository {
    suspend fun getSpecies(id: Int): CoreResult<Species>
}