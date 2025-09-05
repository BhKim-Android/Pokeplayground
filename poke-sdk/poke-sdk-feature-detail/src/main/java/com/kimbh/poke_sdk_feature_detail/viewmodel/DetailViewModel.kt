package com.kimbh.poke_sdk_feature_detail.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kimbh.poke_core_android.model.PokemonType
import com.kimbh.poke_sdk_core.result.CoreResult
import com.kimbh.poke_sdk_core.ui.UiState
import com.kimbh.poke_sdk_domain.usecase.DetailUsecase
import com.kimbh.poke_sdk_domain.usecase.SpeciesUseCase
import com.kimbh.poke_sdk_feature_detail.model.PokemonFullUi
import com.kimbh.poke_sdk_feature_detail.model.UiPokemonDetail
import com.kimbh.poke_sdk_feature_detail.model.UiSpecies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailUsecase: DetailUsecase,
    private val speciesUseCase: SpeciesUseCase
) : ViewModel() {

    var uiState by mutableStateOf<UiState<PokemonFullUi>>(UiState.Loading)
        private set

    fun getDetail(id: Int) {
        viewModelScope.launch {
            val (detailResult, speciesResult) = coroutineScope {
                val detailDeferred = async { detailUsecase(id) }
                val speciesDeferred = async { speciesUseCase(id) }

                detailDeferred.await() to speciesDeferred.await()
            }

            uiState = when {
                detailResult is CoreResult.Success && speciesResult is CoreResult.Success -> {
                    val pokeDetail = detailResult.data
                    val species = speciesResult.data
                    UiState.Success(
                        PokemonFullUi(
                            detail = UiPokemonDetail(
                                id = pokeDetail.id,
                                height = pokeDetail.height,
                                weight = pokeDetail.weight,
                                image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${pokeDetail.id}.png",
                                type = pokeDetail.type.map { PokemonType.fromTypeName(it) }
                            ),
                            species = UiSpecies(
                                id = species.id,
                                name = species.name
                            )
                        )
                    )
                }

                detailResult is CoreResult.Error -> {
                    UiState.Error(detailResult.throwable)
                }

                speciesResult is CoreResult.Error -> {
                    UiState.Error(speciesResult.throwable)
                }

                else -> {
                    UiState.Error(Throwable(""))
                }
            }
        }
    }

//    var uiPokemonDetailState by mutableStateOf<UiState<UiPokemonDetail>>(UiState.Loading)
//        private set     // 외부에서 수정 불가.
//
//    var uiSpeciesState by mutableStateOf<UiState<UiSpecies>>(UiState.Loading)
//        private set
//
//    fun getDetail(id: Int) {
//        viewModelScope.launch {
//            uiPokemonDetailState = when (val result = detailUsecase(id)) {
//                is CoreResult.Success -> {
//                    UiState.Success(
//                        UiPokemonDetail(
//                            id = result.data.id,
//                            height = result.data.height,
//                            weight = result.data.weight,
//                            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
//                        )
//                    )
//                }
//
//                is CoreResult.Error -> {
//                    UiState.Error(result.throwable)
//                }
//            }
//        }
//    }
//
//    fun getSpecies(id: Int) {
//        viewModelScope.launch {
//            uiSpeciesState = when (val result = speciesUseCase(id)) {
//                is CoreResult.Success -> {
//                    UiState.Success(
//                        UiSpecies(id = result.data.id, name = result.data.name)
//                    )
//                }
//
//                is CoreResult.Error -> {
//                    UiState.Error(result.throwable)
//                }
//            }
//        }
//    }
}