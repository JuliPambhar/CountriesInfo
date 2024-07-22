package com.app.domain

sealed class ResponseState<T> {
    class Success<T>(val data: T) : ResponseState<T>()
    class Error<T>(val throwable: Throwable) : ResponseState<T>()
    class NoInternet<T> : ResponseState<T>()
    class Loading<T> : ResponseState<T>()
}