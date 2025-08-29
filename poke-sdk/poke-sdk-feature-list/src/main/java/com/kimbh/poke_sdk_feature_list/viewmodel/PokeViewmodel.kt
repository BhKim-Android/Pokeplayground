package com.kimbh.poke_sdk_feature_list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.kimbh.poke_sdk_domain.usecase.PokeListUsecase
import com.kimbh.poke_sdk_feature_list.model.UiPokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class PokeViewmodel @Inject constructor(
    pokeListUsecase: PokeListUsecase
) : ViewModel() {

    val uiPokemon = pokeListUsecase().map { pagingData ->
        pagingData.map { pokemon ->
            val id = pokemon.url.trimEnd('/').split("/").lastOrNull()?.toIntOrNull() ?: 0
            UiPokemon(
                id = id,
                name = pokemon.name,
                url = pokemon.url,
                image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
            )
        }
    }.cachedIn(viewModelScope)
}