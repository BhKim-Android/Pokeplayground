package com.kimbh.poke_sdk_data

import androidx.paging.PagingData
import androidx.paging.map
import com.kimbh.poke_sdk_core.CoreResult
import com.kimbh.poke_sdk_data.datasource.PokeRemoteDataSource
import com.kimbh.poke_sdk_data.model.toDomain
import com.kimbh.poke_sdk_domain.model.Pokemon
import com.kimbh.poke_sdk_domain.repository.PokeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PokeRepositoryImpl @Inject constructor(
    private val pokeRemoteDataSource: PokeRemoteDataSource
) : PokeRepository {

    override fun pokeList(): Flow<PagingData<Pokemon>> {
        return pokeRemoteDataSource.getPokeList().map { pagingData ->
            pagingData.map { dto ->
                dto.toDomain()
            }
        }
    }
}