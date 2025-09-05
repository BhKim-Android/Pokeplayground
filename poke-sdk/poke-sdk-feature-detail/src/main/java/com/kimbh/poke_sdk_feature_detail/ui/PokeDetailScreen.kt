package com.kimbh.poke_sdk_feature_detail.ui

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.kimbh.poke_sdk_core.ui.UiState
import com.kimbh.poke_sdk_feature_detail.compose.HeaderPokeDetail
import com.kimbh.poke_sdk_feature_detail.viewmodel.DetailViewModel
import kotlinx.serialization.Serializable

@Serializable
data class PokeDetailDestination(val id: Int)

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun PokeDetailScreen(
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
    id: Int,
    viewModel: DetailViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = id) {
        viewModel.getDetail(id)
    }

    val uiState = viewModel.uiState
    when (val result = uiState) {
        is UiState.Loading -> {

        }

        is UiState.Success -> {
            Box(modifier = Modifier.fillMaxSize()) {
                HeaderPokeDetail(
                    sharedTransitionScope = sharedTransitionScope,
                    animatedContentScope = animatedContentScope,
                    modifier = Modifier
                        .fillMaxWidth(),
                    pokemonFullUi = result.data
                )
            }
        }

        is UiState.Error -> {

        }
    }
}