package com.kimbh.poke_sdk_core.utils

object PokeNumberFormat {
    fun format(id: Int): String {
        return "#${id.toString().padStart(3, '0')}"
    }
}