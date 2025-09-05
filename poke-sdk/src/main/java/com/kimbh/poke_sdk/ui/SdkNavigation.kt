package com.kimbh.poke_sdk.ui

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.kimbh.poke_sdk_feature_detail.ui.PokeDetailDestination
import com.kimbh.poke_sdk_feature_detail.ui.PokeDetailScreen
import com.kimbh.poke_sdk_feature_list.ui.PokeListDestination
import com.kimbh.poke_sdk_feature_list.ui.PokeListScreen


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SdkNavigation(
    innerPadding: PaddingValues,
    navController: NavHostController = rememberNavController()
) {
    SharedTransitionLayout {
        NavHost(
            navController = navController,
            startDestination = PokeListDestination,
            modifier = Modifier.padding(innerPadding)
        ) {
            // PokeListDestination
            // 'object' 타입이므로 backStackEntry가 필요 없습니다. 람다의 인자를 제거합니다.
            composable<PokeListDestination> {
                PokeListScreen(
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedContentScope = this@composable,
                    onItemClick = { id ->
                        // PokeDetailDestination으로 이동할 때는 id 값을 담아서 navigate 합니다.
                        navController.navigate(PokeDetailDestination(id))
                    }
                )
            }

            // PokeDetailDestination
            // 'data class' 타입이므로 backStackEntry가 필요합니다. (수정 없음)
            composable<PokeDetailDestination> { backStackEntry ->
                // toRoute()를 통해 id 값을 추출합니다.
                val pokeDetail: PokeDetailDestination = backStackEntry.toRoute()
                PokeDetailScreen(
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedContentScope = this@composable,
                    id = pokeDetail.id
                )
            }
        }
    }
}