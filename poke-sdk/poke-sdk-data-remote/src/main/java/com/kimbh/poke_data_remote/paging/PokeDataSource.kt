package com.kimbh.poke_data_remote.paging

import com.kimbh.poke_data_remote.api.PokeApiService
import com.kimbh.poke_data_remote.model.pokelist.PokeListResponse
import retrofit2.Response
import javax.inject.Inject

class PokeDataSource @Inject constructor(
    private val pokeApiService: PokeApiService
) {
    suspend fun pokeList(url: String): Response<PokeListResponse> =
        pokeApiService.pokeList(url)
}