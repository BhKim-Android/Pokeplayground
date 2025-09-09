package com.kimbh.poke_sdk_feature_detail.compose.stats

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kimbh.poke_sdk_feature_detail.model.PokemonFullUi

@Composable
fun StatsContentsPokeDetail(pokemonFullUi: PokemonFullUi) {

    Column(
        modifier = Modifier.padding(all = 20.dp)
    ) {
        Text(
            text = "Breeding",
            fontSize = 20.sp,
        )

        Spacer(modifier = Modifier.height(20.dp))

        pokemonFullUi.detail.stats.forEach {
            BaseStats(stats = it, color = pokemonFullUi.detail.type[0].color)
        }
    }
}