package com.kimbh.poke_data_remote

import com.kimbh.poke_data_remote.api.PokeApiService
import com.kimbh.poke_sdk_core.CoreResult
import com.kimbh.poke_sdk_data.datasource.DataSource
import com.kimbh.poke_sdk_data.model.PokeListDTO
import javax.inject.Inject

class DataSourceImpl @Inject constructor(
    private val pokeApiService: PokeApiService
) : DataSource {
    override suspend fun getPokeList(): CoreResult<List<PokeListDTO>> {
        return try {
            val response = pokeApiService.pokeList()
            if (response.isSuccessful) {
                response.body()?.let { data ->
                    CoreResult.Success(data.results.map {
                        PokeListDTO(name = it.name, url = it.url)
                    })
                } ?: let {
                    CoreResult.Error(Throwable("데이터가 없음"))
                }
            } else {
                CoreResult.Error(Throwable(response.message()))
            }
        } catch (e: Exception) {
            e.printStackTrace()
            CoreResult.Error(e)
        }
    }
}