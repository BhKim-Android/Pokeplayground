package com.kimbh.poke_sdk_feature_detail.compose.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kimbh.poke_sdk_core.utils.PokeGenderRate
import com.kimbh.poke_sdk_core.utils.PokemonUnitConverter
import com.kimbh.poke_sdk_feature_detail.model.PokemonFullUi

/**
 * height, weight
 *
 * base_experience
 *
 * abilities (숨겨진 특성 포함)
 *
 * types
 */

@Composable
fun AboutContentsPokeDetail(
    pokemonFullUi: PokemonFullUi
) {
    Column(modifier = Modifier.padding(all = 20.dp)) {
        Text(text = pokemonFullUi.species.flavor_text)

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "PokeDex Data",
            fontSize = 20.sp,
        )

        PokeDexData(title = "Species", value = pokemonFullUi.species.genera)

        PokeDexData(
            title = "Weight",
            value = "${pokemonFullUi.detail.weight}Hg(${
                PokemonUnitConverter.weightToKg(pokemonFullUi.detail.weight)
            }Kg)"
        )

        PokeDexData(
            title = "Height",
            value = "${pokemonFullUi.detail.height}Dm(${
                PokemonUnitConverter.heightToMeters(pokemonFullUi.detail.height)
            }M)"
        )

        PokeDexData(
            title = "abilities",
            value = pokemonFullUi.detail.abilities.joinToString(", ")
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Breeding",
            fontSize = 20.sp,
        )

        PokeDexData(
            title = "Gender",
            value = PokeGenderRate.getGenderRate(pokemonFullUi.species.gender_rate)?.let {
                "Male : ${it.first}%, Female : ${it.second}%"
            } ?: let {
                "Genderless"
            }
        )

        PokeDexData(
            title = "Egg groups",
            value = pokemonFullUi.species.egg_groups.joinToString(", ")
        )
    }
}

@Preview
@Composable
fun AboutContentsPokeDetailPreview() {
//    AboutContentsPokeDetail()
}