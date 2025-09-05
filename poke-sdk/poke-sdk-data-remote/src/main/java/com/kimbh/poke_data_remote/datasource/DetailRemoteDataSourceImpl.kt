package com.kimbh.poke_data_remote.datasource

import com.kimbh.poke_data_remote.api.PokeApiService
import com.kimbh.poke_sdk_core.result.CoreResult
import com.kimbh.poke_sdk_data.datasource.DetailRemoteDataSource
import com.kimbh.poke_sdk_data.model.PokeDetailDTO
import javax.inject.Inject

class DetailRemoteDataSourceImpl @Inject constructor(
    private val pokeApiService: PokeApiService
) : DetailRemoteDataSource {
    override suspend fun getPokeDetail(id: Int): CoreResult<PokeDetailDTO> {
        return try {
            val response = pokeApiService.pokemon(id)

            if (response.isSuccessful) {
                response.body()?.let {
                    // 성공..
                    CoreResult.Success(
                        data = PokeDetailDTO(
                            id = it.id,
                            height = it.height,
                            weight = it.weight,
                            type = it.types.map { typesResponse -> typesResponse.type.name }
                        )
                    )
                } ?: let {
                    // no Response..
                    CoreResult.Error(Throwable("No Response"))
                }
            } else {
                response.errorBody()?.let {
                    CoreResult.Error(Throwable(it.string()))
                } ?: let {
                    CoreResult.Error(Throwable("error empty"))
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            CoreResult.Error(e)
        }
    }
}