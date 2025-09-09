package com.kimbh.poke_data_remote.datasource

import com.kimbh.poke_data_remote.api.PokeApiService
import com.kimbh.poke_sdk_core.result.CoreResult
import com.kimbh.poke_sdk_data.datasource.SpeciesRemoteDataSource
import com.kimbh.poke_sdk_data.model.LanguageDTO
import com.kimbh.poke_sdk_data.model.species.FlavorTextDTO
import com.kimbh.poke_sdk_data.model.species.GeneraDTO
import com.kimbh.poke_sdk_data.model.species.SpeciesDto
import javax.inject.Inject

class SpeciesRemoteDataSourceImpl @Inject constructor(
    private val pokeApiService: PokeApiService
) : SpeciesRemoteDataSource {
    override suspend fun getSpecies(id: Int): CoreResult<SpeciesDto> {
        return try {
            val response = pokeApiService.pokemonSpecies(id)

            response.body()?.let { data ->
                CoreResult.Success(
                    SpeciesDto(
                        id = data.id,
                        name = data.name,
                        gender_rate = data.gender_rate,
                        flavor_text_entries = data.flavor_text_entries.map { flavorTextEntryResponse ->
                            FlavorTextDTO(
                                flavor_text = flavorTextEntryResponse.flavor_text,
                                language = LanguageDTO(name = flavorTextEntryResponse.language.name),
                            )
                        },
                        egg_groups = data.egg_groups.map { eggGroupResponse ->
                            eggGroupResponse.name
                        },
                        genera = data.genera.map { generaResponse ->
                            GeneraDTO(
                                genus = generaResponse.genus,
                                language = LanguageDTO(name = generaResponse.language.name)
                            )
                        }
                    )
                )
            } ?: response.errorBody()?.let { error ->
                CoreResult.Error(Throwable(error.string()))
            } ?: let {
                CoreResult.Error(Throwable("No Response"))
            }
        } catch (e: Exception) {
            e.printStackTrace()
            CoreResult.Error(e)
        }
    }
}