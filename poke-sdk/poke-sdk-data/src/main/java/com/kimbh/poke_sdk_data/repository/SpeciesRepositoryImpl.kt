package com.kimbh.poke_sdk_data.repository

import com.kimbh.poke_sdk_core.result.CoreResult
import com.kimbh.poke_sdk_data.datasource.SpeciesRemoteDataSource
import com.kimbh.poke_sdk_domain.model.Species
import com.kimbh.poke_sdk_domain.repository.SpeciesRepository
import javax.inject.Inject

class SpeciesRepositoryImpl @Inject constructor(
    private val speciesRemoteDataSource: SpeciesRemoteDataSource
) : SpeciesRepository {
    override suspend fun getSpecies(id: Int): CoreResult<Species> {
        return when (val result = speciesRemoteDataSource.getSpecies(id)) {
            is CoreResult.Success -> {
                CoreResult.Success(data = Species(id = result.data.id, name = result.data.name))
            }

            is CoreResult.Error -> {
                result
            }
        }
    }
}