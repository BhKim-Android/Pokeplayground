package com.kimbh.poke_sdk_domain.usecase

import androidx.paging.PagingData
import com.kimbh.poke_sdk_domain.model.Pokemon
import com.kimbh.poke_sdk_domain.repository.ListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ListUsecase @Inject constructor(
    private val listRepository: ListRepository
) {
    operator fun invoke(): Flow<PagingData<Pokemon>> {
        return listRepository.pokeList()
    }
}