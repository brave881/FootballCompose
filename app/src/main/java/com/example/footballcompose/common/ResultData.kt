package com.example.footballcompose.common

sealed class ResultData<T> {
    data class Success<T>(val data: T? = null) : ResultData<T>()
    class Error<T>(val message: String = "") : ResultData<T>()
    class Loading<T>(val isLoading: Boolean = false) : ResultData<T>()
}