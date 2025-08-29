package com.kimbh.poke_sdk_feature_list.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.kimbh.poke_sdk_feature_list.model.UiPokemon

@Composable
fun PokeItem(uiPokemon: UiPokemon) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clip(shape = RoundedCornerShape(size = 10.dp))
            .background(color = Color.White)
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = uiPokemon.image, contentDescription = "pokemon image",
            modifier = Modifier
                .weight(0.8f)
                .aspectRatio(1f)
        )
        Text(
            text = uiPokemon.name,
            modifier = Modifier.weight(0.2f)
        )
    }
}