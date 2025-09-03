package com.kimbh.poke_sdk_domain.usecase

import com.kimbh.poke_sdk_core.result.CoreResult
import com.kimbh.poke_sdk_domain.model.Species
import com.kimbh.poke_sdk_domain.repository.SpeciesRepository
import javax.inject.Inject

class SpeciesUseCase @Inject constructor(
    private val speciesRepository: SpeciesRepository
) {
    suspend operator fun invoke(id: Int): CoreResult<Species> {
        return speciesRepository.getSpecies(id)
    }
}