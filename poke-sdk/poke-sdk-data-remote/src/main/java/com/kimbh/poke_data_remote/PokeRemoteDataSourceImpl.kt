package com.kimbh.poke_data_remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kimbh.poke_data_remote.paging.PokeDataSource
import com.kimbh.poke_data_remote.paging.PokePagingSource
import com.kimbh.poke_sdk_data.datasource.PokeRemoteDataSource
import com.kimbh.poke_sdk_data.model.PokeListDTO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokeRemoteDataSourceImpl @Inject constructor(
    private val pokeDataSource: PokeDataSource
) : PokeRemoteDataSource {
    override fun getPokeList(): Flow<PagingData<PokeListDTO>> =
        Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { PokePagingSource(pokeDataSource = pokeDataSource) }
        ).flow
}