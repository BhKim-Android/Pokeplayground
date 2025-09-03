package com.kimbh.poke_sdk_domain.usecase

import com.kimbh.poke_sdk_core.result.CoreResult
import com.kimbh.poke_sdk_domain.model.PokeDetail
import com.kimbh.poke_sdk_domain.repository.DetailRepository
import javax.inject.Inject

class DetailUsecase @Inject constructor(
    private val detailRepository: DetailRepository
) {
    suspend operator fun invoke(id: Int): CoreResult<PokeDetail> {
        return detailRepository.detail(id)
    }
}