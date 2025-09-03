package com.kimbh.poke_sdk_data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.kimbh.poke_sdk_data.datasource.ListRemoteDataSource
import com.kimbh.poke_sdk_data.model.toDomain
import com.kimbh.poke_sdk_domain.model.Pokemon
import com.kimbh.poke_sdk_domain.repository.ListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ListRepositoryImpl @Inject constructor(
    private val listRemoteDataSource: ListRemoteDataSource
) : ListRepository {

    override fun pokeList(): Flow<PagingData<Pokemon>> {
        return listRemoteDataSource.getPokeList().map { pagingData ->
            pagingData.map { dto ->
                dto.toDomain()
            }
        }
    }
}