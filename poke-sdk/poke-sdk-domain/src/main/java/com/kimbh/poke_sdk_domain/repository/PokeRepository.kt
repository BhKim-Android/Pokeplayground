package com.kimbh.poke_sdk_domain.repository

import androidx.paging.PagingData
import com.kimbh.poke_sdk_domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokeRepository {
    fun pokeList(): Flow<PagingData<Pokemon>>
}