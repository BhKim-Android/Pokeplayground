package com.kimbh.poke_sdk_core.utils

object PokemonUnitConverter {
    /** height(dm) → m (소수점 한 자리) */
    fun heightToMeters(heightDm: Int): Double {
        return heightDm / 10.0
    }

    /** weight(hg) → kg (소수점 한 자리) */
    fun weightToKg(weightHg: Int): Double {
        return weightHg / 10.0
    }
}