package com.kimbh.poke_sdk_feature_detail.compose

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.kimbh.poke_core_android.model.PokemonType
import com.kimbh.poke_sdk_core.utils.PokeNumberFormat
import com.kimbh.poke_sdk_feature_detail.model.PokemonFullUi
import com.kimbh.poke_sdk_feature_detail.model.UiPokemonDetail
import com.kimbh.poke_sdk_feature_detail.model.UiSpecies

@OptIn(ExperimentalMaterial3Api::class, ExperimentalSharedTransitionApi::class)
@Composable
fun HeaderPokeDetail(
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
    modifier: Modifier,
    pokemonFullUi: PokemonFullUi
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TopAppBar(
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
                containerColor = Color.Transparent, // 배경 투명 처리
                scrolledContainerColor = Color.Transparent
            )
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.height(IntrinsicSize.Min)
        ) {
            with(sharedTransitionScope) {
                AsyncImage(
                    model = pokemonFullUi.detail.image, contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth(0.4f)
                        .sharedElement(
                            sharedContentState = sharedTransitionScope.rememberSharedContentState(
                                key = "image-${pokemonFullUi.detail.id}"
                            ),
                            animatedVisibilityScope = animatedContentScope
                        )
                )
                Column(
                    modifier = Modifier.height(IntrinsicSize.Min),
                    verticalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Text(
                        text = pokemonFullUi.species.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.sharedElement(
                            sharedContentState = sharedTransitionScope.rememberSharedContentState(
                                key = "name-${pokemonFullUi.species.name}"
                            ),
                            animatedVisibilityScope = animatedContentScope
                        )
                    )
                    Text(
                        text = PokeNumberFormat.format(pokemonFullUi.detail.id),
                        color = Color.Gray,
                        modifier = Modifier
                            .sharedElement(
                            sharedContentState = sharedTransitionScope.rememberSharedContentState(
                                key = "id-${pokemonFullUi.detail.id}"
                            ),
                            animatedVisibilityScope = animatedContentScope
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    pokemonFullUi.detail.type.forEach {
                        Row(
                            modifier = Modifier
                                .background(color = Color.Transparent)
                                .border(
                                    border = BorderStroke(width = 1.dp, color = it.color),
                                    shape = RoundedCornerShape(size = 10.dp)
                                )
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(size = 10.dp)
                                )
                                .padding(vertical = 4.dp, horizontal = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(it.resource),
                                contentDescription = null,
                                modifier = Modifier.height(15.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = it.name,
                                color = it.color,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@SuppressLint("UnusedContentLambdaTargetStateParameter")
@OptIn(ExperimentalSharedTransitionApi::class) // Preview 함수에도 어노테이션 추가
@Preview(showBackground = true)
@Composable
private fun HeaderPokeDetailPreview() { // Preview는 private으로 선언하는 것이 좋습니다.
    // 1. SharedTransitionScope를 제공하기 위해 SharedTransitionLayout으로 감쌉니다.
    SharedTransitionLayout {
        // 2. AnimatedContentScope를 제공하기 위해 AnimatedContent로 감쌉니다.
        //    targetState는 Preview 목적이므로 임의의 값을 사용합니다. (e.g., true)
        AnimatedContent(
            targetState = true,
            label = "PokemonDetailPreview"
        ) {
            // 3. 각 레이아웃의 스코프를 'this@...'를 사용해 명시적으로 전달합니다.
            HeaderPokeDetail(
                sharedTransitionScope = this@SharedTransitionLayout,
                animatedContentScope = this@AnimatedContent,
                modifier = Modifier.fillMaxWidth(),
                pokemonFullUi = PokemonFullUi(
                    detail = UiPokemonDetail(
                        id = 1,
                        height = 7,
                        weight = 69,
                        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
                        type = listOf(PokemonType.GRASS, PokemonType.POISON)
                    ),
                    species = UiSpecies(id = 1, name = "이상해씨") // 예시 이름 수정
                )
            )
        }
    }
}