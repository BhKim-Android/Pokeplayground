package com.kimbh.poke_sdk_data.datasource

import androidx.paging.PagingData
import com.kimbh.poke_sdk_data.model.PokeListDTO
import kotlinx.coroutines.flow.Flow

interface ListRemoteDataSource {
    fun getPokeList(): Flow<PagingData<PokeListDTO>>
}