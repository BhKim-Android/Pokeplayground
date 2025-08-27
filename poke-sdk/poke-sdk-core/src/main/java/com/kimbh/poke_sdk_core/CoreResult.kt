package com.kimbh.poke_sdk_core

sealed class CoreResult<out T> {
    data class Success<T>(val data: T): CoreResult<T>()
    data class Error(val throwable: Throwable): CoreResult<Nothing>()
}