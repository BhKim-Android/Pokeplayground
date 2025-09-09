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
                CoreResult.Success(
                    data = Species(
                        id = result.data.id,
                        name = result.data.name,
                        flavor_text = result.data.flavor_text_entries.firstOrNull { flavorTextDTO ->
                            flavorTextDTO.language.name == "ko"
                        }?.flavor_text.orEmpty(),
                        gender_rate = result.data.gender_rate,
                        egg_groups = result.data.egg_groups,
                        genera = result.data.genera.firstOrNull { generaDTO ->
                            generaDTO.language.name == "ko"
                        }?.genus.orEmpty()
                    )
                )
            }

            is CoreResult.Error -> {
                result
            }
        }
    }
}