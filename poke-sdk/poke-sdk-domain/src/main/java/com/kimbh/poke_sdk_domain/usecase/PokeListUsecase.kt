package com.kimbh.poke_sdk_domain.usecase

import androidx.paging.PagingData
import com.kimbh.poke_sdk_domain.model.Pokemon
import com.kimbh.poke_sdk_domain.repository.PokeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokeListUsecase @Inject constructor(
    private val pokeRepository: PokeRepository
) {
    operator fun invoke(): Flow<PagingData<Pokemon>> {
        return pokeRepository.pokeList()
    }
}