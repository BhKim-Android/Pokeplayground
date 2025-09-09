package com.kimbh.poke_sdk_data.repository

import com.kimbh.poke_sdk_core.result.CoreResult
import com.kimbh.poke_sdk_data.datasource.DetailRemoteDataSource
import com.kimbh.poke_sdk_domain.model.PokeDetail
import com.kimbh.poke_sdk_domain.model.StatDetail
import com.kimbh.poke_sdk_domain.repository.DetailRepository
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val detailRemoteDataSource: DetailRemoteDataSource
) : DetailRepository {
    override suspend fun detail(id: Int): CoreResult<PokeDetail> {
        return when (val result = detailRemoteDataSource.getPokeDetail(id)) {
            is CoreResult.Success -> {
                CoreResult.Success(
                    data = PokeDetail(
                        id = result.data.id,
                        height = result.data.height,
                        weight = result.data.weight,
                        abilities = result.data.abilities,
                        stats = result.data.stats.map {
                            StatDetail(base_stat = it.base_stat, name = it.name)
                        },
                        type = result.data.type
                    )
                )
            }

            is CoreResult.Error -> {
                result
            }
        }
    }
}