package com.kimbh.poke_data_remote.api

import com.kimbh.poke_data_remote.model.pokelist.PokeListResponse
import com.kimbh.poke_data_remote.model.pokemon.PokemonResponse
import com.kimbh.poke_data_remote.model.species.SpeciesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {

    // 기본 리스트
    @GET("/pokemon")
    suspend fun pokeList(
        @Query("limit") limit: Int = 20
    ): Response<PokeListResponse>

    // 이미지/스텟
    @GET("/pokemon/{id}")
    suspend fun pokemon(
        @Path("id") id: Int
    ): Response<PokemonResponse>

    // 이름
    @GET("/pokemon-species/{id}")
    suspend fun pokemonSpecies(
        @Path("id") id: Int
    ): Response<SpeciesResponse>
}