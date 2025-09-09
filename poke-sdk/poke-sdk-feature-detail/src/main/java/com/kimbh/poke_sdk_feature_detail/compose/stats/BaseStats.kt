package com.kimbh.poke_sdk_feature_detail.compose.stats

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kimbh.poke_sdk_feature_detail.model.Stats

@Composable
fun BaseStats(stats: Stats, color: Color) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = stats.name,
            modifier = Modifier.weight(3f)
        )

        Text(
            text = stats.base_stat.toString(),
            modifier = Modifier.weight(1f)
        )

        LinearProgressIndicator(
            progress = { stats.base_stat / 255f },
            modifier = Modifier
                .weight(4f),
            color = color,
            trackColor = Color.LightGray,
            gapSize = 0.dp
        )
    }
}

@Preview
@Composable
fun BaseStatsPreview() {
    BaseStats(
        Stats(
            base_stat = 65,
            name = "special-defense"
        ),
        Color.Green
    )
}