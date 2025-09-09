package com.kimbh.poke_sdk_data.datasource

import com.kimbh.poke_sdk_core.result.CoreResult
import com.kimbh.poke_sdk_data.model.detail.PokeDetailDTO

interface DetailRemoteDataSource {
    suspend fun getPokeDetail(id: Int): CoreResult<PokeDetailDTO>
}