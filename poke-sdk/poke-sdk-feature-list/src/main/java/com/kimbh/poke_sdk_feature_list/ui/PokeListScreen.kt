package com.kimbh.poke_sdk_feature_list.ui

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.kimbh.poke_sdk_feature_list.compose.PokeItem
import com.kimbh.poke_sdk_feature_list.viewmodel.ListViewmodel
import kotlinx.serialization.Serializable

@Serializable
object PokeListDestination

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun PokeListScreen(
    viewmodel: ListViewmodel = hiltViewModel(),
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
    onItemClick: (Int) -> Unit
) {
    val lazyPagingItems = viewmodel.uiPokemonList.collectAsLazyPagingItems()

    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 3),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(10.dp)
    ) {
        items(
            count = lazyPagingItems.itemCount,
            key = lazyPagingItems.itemKey { it.name }
        ) { index ->
            lazyPagingItems[index]?.let { item ->
                PokeItem(
                    sharedTransitionScope = sharedTransitionScope,
                    animatedContentScope = animatedContentScope,
                    uiPokemonList = item
                ) {
                    onItemClick(item.id)
                }
            }
        }
    }
}