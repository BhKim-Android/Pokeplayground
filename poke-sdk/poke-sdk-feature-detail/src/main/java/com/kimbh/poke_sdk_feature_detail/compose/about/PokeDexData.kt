package com.kimbh.poke_sdk_feature_detail.compose.about

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PokeDexData(
    title: String,
    value: String
) {
    Row(
        modifier = Modifier.padding(vertical = 10.dp)
    ) {
        Text(
            text = title,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = value,
            color = Color.Gray,
            modifier = Modifier.weight(2f)
        )
    }
}

@Preview
@Composable
fun PokeDexDataPreview() {
    PokeDexData("Weight", "31Kg")
}