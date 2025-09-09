package com.kimbh.poke_sdk_feature_detail.ui

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.kimbh.poke_sdk_core.ui.UiState
import com.kimbh.poke_sdk_feature_detail.compose.ContentsPokeDetail
import com.kimbh.poke_sdk_feature_detail.compose.HeaderPokeDetail
import com.kimbh.poke_sdk_feature_detail.viewmodel.DetailViewModel
import kotlinx.serialization.Serializable

@Serializable
data class PokeDetailDestination(val id: Int)

@OptIn(ExperimentalSharedTransitionApi::class, ExperimentalMaterial3Api::class)
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
    var selectTabIndex by remember { mutableIntStateOf(0) }

    var headerSize by remember { mutableStateOf(IntSize.Zero) }
    val headerHeight = with(LocalDensity.current) { headerSize.height.toDp() }
    var appbarSize by remember { mutableStateOf(IntSize.Zero) }
    val appbarHeight = with(LocalDensity.current) { appbarSize.height.toDp() }
    var tabSize by remember { mutableStateOf(IntSize.Zero) }
    val tabHeight = with(LocalDensity.current) { tabSize.height.toDp() }

    var offsetHeight by remember { mutableFloatStateOf(0f) }
    val offsetHeightcurrent = with(LocalDensity.current) { offsetHeight.toDp() }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                if (headerSize.height == 0) return Offset.Zero

                val availableY = offsetHeight + available.y
                offsetHeight = availableY.coerceIn(-(headerSize.height.toFloat()), 0f)

                return Offset(0f, offsetHeight - (availableY - available.y))
            }
        }
    }

    when (val result = uiState) {
        is UiState.Loading -> {

        }

        is UiState.Success -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                        .nestedScroll(nestedScrollConnection)
                        .padding(top = appbarHeight) // ✨ TopAppBar 높이만큼 패딩을 주어 시작 위치를 잡습니다.
                        .clipToBounds() // ✨ 가장 중요한 부분! 이 Box 밖으로 자식 View가 그려지는 것을 막습니다.
                ) {
                    HeaderPokeDetail(
                        sharedTransitionScope = sharedTransitionScope,
                        animatedContentScope = animatedContentScope,
                        modifier = Modifier
                            .fillMaxWidth()
                            .onSizeChanged { headerSize = it }
                            .graphicsLayer {
                                translationY = offsetHeight
                            },
                        pokemonFullUi = result.data
                    )

                    SecondaryTabRow(
                        selectedTabIndex = selectTabIndex,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = headerHeight)
                            .background(color = Color.White)
                            .onSizeChanged {
                                tabSize = it
                            }
                            .graphicsLayer {
                                translationY = offsetHeight
                            }
                    ) {
                        // 탭 구현..
                        Tab(
                            selected = selectTabIndex == 0,
                            text = { Text(text = "About") },
                            onClick = {
                                selectTabIndex = 0
                            })

                        Tab(
                            selected = selectTabIndex == 1,
                            text = { Text(text = "Base stats") },
                            onClick = {
                                selectTabIndex = 1
                            })

                        Tab(
                            selected = selectTabIndex == 2,
                            text = { Text(text = "Evolution") },
                            onClick = {
                                selectTabIndex = 2
                            })

                        Tab(
                            selected = selectTabIndex == 3,
                            text = { Text(text = "Moves") },
                            onClick = {
                                selectTabIndex = 3
                            })
                    }

                    ContentsPokeDetail(
                        selectTabIndex = selectTabIndex,
                        pokemonFullUi = result.data,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                top = (headerHeight + tabHeight)
                                        + offsetHeightcurrent
                            )
                            .verticalScroll(rememberScrollState())
                    )
                }

                TopAppBar(
                    windowInsets = WindowInsets(0, 0, 0, 0),
                    title = { },
                    navigationIcon = {
                        IconButton(onClick = { /* TODO */ }) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* TODO */ }) {
                            Icon(Icons.Default.Settings, contentDescription = "Settings")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White,
                        scrolledContainerColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .onSizeChanged { appbarSize = it }
                )
            }
        }

        is UiState.Error -> {

        }
    }
}