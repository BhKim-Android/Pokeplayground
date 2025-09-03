package com.kimbh.poke_sdk_feature_detail.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.kimbh.poke_sdk_feature_detail.viewmodel.DetailViewModel
import kotlinx.serialization.Serializable

@Serializable
data class PokeDetailDestination(val id: Int)

@Composable
fun PokeDetailScreen(
    id: Int,
    viewModel: DetailViewModel = hiltViewModel()
) {

}