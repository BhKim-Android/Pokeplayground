package com.kimbh.poke_sdk_core.utils

object PokeGenderRate {
    fun getGenderRate(genderRate: Int): Pair<String, String>? {
        return when (genderRate) {
            -1 -> null // 성별 없음
            else -> {
                val female = genderRate * 12.5
                val male = 100 - female
                male.toString() to female.toString()
            }
        }
    }
}