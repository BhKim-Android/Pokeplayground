package com.kimbh.poke_sdk_feature_detail.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kimbh.poke_sdk_core.result.CoreResult
import com.kimbh.poke_sdk_core.ui.UiState
import com.kimbh.poke_sdk_domain.usecase.DetailUsecase
import com.kimbh.poke_sdk_domain.usecase.SpeciesUseCase
import com.kimbh.poke_sdk_feature_detail.model.UiPokemonDetail
import com.kimbh.poke_sdk_feature_detail.model.UiSpecies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailUsecase: DetailUsecase,
    private val speciesUseCase: SpeciesUseCase
) : ViewModel() {

    var uiPokemonDetailState by mutableStateOf<UiState<UiPokemonDetail>>(UiState.Loading)
        private set     // 외부에서 수정 불가.

    var uiSpeciesState by mutableStateOf<UiState<UiSpecies>>(UiState.Loading)
        private set

    fun getDetail(id: Int) {
        viewModelScope.launch {
            uiPokemonDetailState = when (val result = detailUsecase(id)) {
                is CoreResult.Success -> {
                    UiState.Success(
                        UiPokemonDetail(
                            id = result.data.id,
                            height = result.data.height,
                            weight = result.data.weight
                        )
                    )
                }

                is CoreResult.Error -> {
                    UiState.Error(result.throwable)
                }
            }
        }
    }

    fun getSpecies(id: Int) {
        viewModelScope.launch {
            uiSpeciesState = when (val result = speciesUseCase(id)) {
                is CoreResult.Success -> {
                    UiState.Success(
                        UiSpecies(id = result.data.id, name = result.data.name)
                    )
                }

                is CoreResult.Error -> {
                    UiState.Error(result.throwable)
                }
            }
        }
    }
}