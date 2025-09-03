package com.kimbh.poke_sdk_feature_list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.kimbh.poke_sdk_domain.usecase.ListUsecase
import com.kimbh.poke_sdk_feature_list.model.UiPokemonList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ListViewmodel @Inject constructor(
    listUsecase: ListUsecase
) : ViewModel() {

    val uiPokemonList = listUsecase().map { pagingData ->
        pagingData.map { pokemon ->
            val id = pokemon.url.trimEnd('/').split("/").lastOrNull()?.toIntOrNull() ?: 0
            UiPokemonList(
                id = id,
                name = pokemon.name,
                url = pokemon.url,
                image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
            )
        }
    }.cachedIn(viewModelScope)
}