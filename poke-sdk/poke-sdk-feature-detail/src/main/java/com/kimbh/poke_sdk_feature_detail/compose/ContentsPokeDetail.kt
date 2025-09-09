package com.kimbh.poke_sdk_feature_detail.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kimbh.poke_sdk_feature_detail.compose.about.AboutContentsPokeDetail
import com.kimbh.poke_sdk_feature_detail.compose.evolution.EvolutionContentsPokeDetail
import com.kimbh.poke_sdk_feature_detail.compose.stats.StatsContentsPokeDetail
import com.kimbh.poke_sdk_feature_detail.model.PokemonFullUi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentsPokeDetail(
    selectTabIndex: Int,
    pokemonFullUi: PokemonFullUi,
    modifier: Modifier
) {
    Box(
        modifier = modifier
    ) {
        when(selectTabIndex) {
            0 -> AboutContentsPokeDetail(pokemonFullUi = pokemonFullUi)
            1 -> StatsContentsPokeDetail(pokemonFullUi = pokemonFullUi)
            2 -> EvolutionContentsPokeDetail(pokemonFullUi = pokemonFullUi)
        }
    }
}