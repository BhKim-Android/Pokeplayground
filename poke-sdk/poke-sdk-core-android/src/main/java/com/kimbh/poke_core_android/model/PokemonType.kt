package com.kimbh.poke_core_android.model

import androidx.compose.ui.graphics.Color
import com.kimbh.poke_core_android.R

enum class PokemonType(val color: Color, val resource: Int) {
    NORMAL(Color(0xFFa8a77a), R.drawable.normal),
    FIRE(Color(0xFFee8130), R.drawable.fire),
    WATER(Color(0xFF6390f0), R.drawable.water),
    GRASS(Color(0xFF7ac74c), R.drawable.grass),
    ELECTRIC(Color(0xFFf7d02c), R.drawable.electric),
    ICE(Color(0xFF96d9d6), R.drawable.ice),
    FIGHTING(Color(0xFFc22e28), R.drawable.fighting),
    POISON(Color(0xFFa33ea1), R.drawable.poison),
    GROUND(Color(0xFFe2bf65), R.drawable.ground),
    FLYING(Color(0xFFa98ff3), R.drawable.flying),
    PSYCHIC(Color(0xFFf95587), R.drawable.psychic),
    BUG(Color(0xFFa6b91a), R.drawable.bug),
    ROCK(Color(0xFFb6a136), R.drawable.rock),
    GHOST(Color(0xFF735797), R.drawable.ghost),
    DRAGON(Color(0xFF6f35fc), R.drawable.dragon),
    STEEL(Color(0xFFb7b7ce), R.drawable.steel),
    DARK(Color(0xFF705746), R.drawable.dark),
    FAIRY(Color(0xFFd685ad), R.drawable.fairy);

    companion object {
        fun fromTypeName(name: String): PokemonType {
            return entries.firstOrNull { it.name.equals(name, ignoreCase = true) } ?: NORMAL
        }
    }
}