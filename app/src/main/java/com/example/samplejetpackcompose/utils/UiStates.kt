package com.example.samplejetpackcompose.utils

sealed class UiStates<out T> {
    object Loading : UiStates<Nothing>()
    data class Success<out T>(val data: T) : UiStates<T>()
    data class Error(var error: String) : UiStates<Nothing>()
}