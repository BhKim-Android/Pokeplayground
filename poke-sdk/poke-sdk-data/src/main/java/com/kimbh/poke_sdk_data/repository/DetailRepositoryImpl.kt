package com.kimbh.poke_sdk_data.repository

import com.kimbh.poke_sdk_core.result.CoreResult
import com.kimbh.poke_sdk_data.datasource.DetailRemoteDataSource
import com.kimbh.poke_sdk_domain.model.PokeDetail
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
                        weight = result.data.weight
                    )
                )
            }

            is CoreResult.Error -> {
                result
            }
        }
    }
}