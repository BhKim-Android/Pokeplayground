package com.kimbh.poke_data_remote.datasource

import com.kimbh.poke_data_remote.api.PokeApiService
import com.kimbh.poke_sdk_core.result.CoreResult
import com.kimbh.poke_sdk_data.datasource.SpeciesRemoteDataSource
import com.kimbh.poke_sdk_data.model.SpeciesDto
import javax.inject.Inject

class SpeciesRemoteDataSourceImpl @Inject constructor(
    private val pokeApiService: PokeApiService
) : SpeciesRemoteDataSource {
    override suspend fun getSpecies(id: Int): CoreResult<SpeciesDto> {
        return try {
            val response = pokeApiService.pokemonSpecies(id)

            response.body()?.let { data ->
                CoreResult.Success(SpeciesDto(data.id, data.name))
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