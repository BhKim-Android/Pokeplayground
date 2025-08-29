package com.kimbh.poke_sdk_data.datasource

import androidx.paging.PagingData
import com.kimbh.poke_sdk_data.model.PokeListDTO
import kotlinx.coroutines.flow.Flow

interface PokeRemoteDataSource {
    fun getPokeList(): Flow<PagingData<PokeListDTO>>
}