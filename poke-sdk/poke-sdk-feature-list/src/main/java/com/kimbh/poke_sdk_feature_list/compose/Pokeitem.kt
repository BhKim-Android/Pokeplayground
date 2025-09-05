package com.kimbh.poke_sdk_feature_list.compose

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.kimbh.poke_sdk_feature_list.model.UiPokemonList
import java.util.Locale

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun PokeItem(
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
    uiPokemonList: UiPokemonList,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(0.8f)
            .clip(shape = RoundedCornerShape(size = 10.dp))
            .background(color = Color.White)
            .padding(10.dp)
            .clickable {
                onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        with(sharedTransitionScope) {
            AsyncImage(
                model = uiPokemonList.image, contentDescription = "pokemon image",
                modifier = Modifier
                    .weight(0.8f)
                    .aspectRatio(1f)
                    .sharedElement(
                        sharedContentState = sharedTransitionScope.rememberSharedContentState(key = "image-${uiPokemonList.id}"),
                        animatedVisibilityScope = animatedContentScope
                    )
            )
            Text(
                text = uiPokemonList.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(0.2f)
                    .sharedElement(
                        sharedContentState = sharedTransitionScope.rememberSharedContentState(key = "name-${uiPokemonList.name}"),
                        animatedVisibilityScope = animatedContentScope
                    )
            )
            Text(
                text = String.format(Locale.US, "#%03d", uiPokemonList.id),
                modifier = Modifier
                    .weight(0.2f)
                    .sharedElement(
                        sharedContentState = sharedTransitionScope.rememberSharedContentState(key = "id-${uiPokemonList.id}"),
                        animatedVisibilityScope = animatedContentScope
                    ),
                color = Color.Gray
            )
        }
    }
}