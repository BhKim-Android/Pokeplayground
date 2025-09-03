package com.kimbh.poke_sdk_domain.repository

import com.kimbh.poke_sdk_core.result.CoreResult
import com.kimbh.poke_sdk_domain.model.PokeDetail

interface DetailRepository {
    suspend fun detail(id: Int): CoreResult<PokeDetail>
}