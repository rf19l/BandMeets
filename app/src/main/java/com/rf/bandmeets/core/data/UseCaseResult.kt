package com.rf.bandmeets.core.data

sealed class UseCaseResult<out T> {
    data class Success<out T>(val data: T) : UseCaseResult<T>()

    data class Error(val error: Throwable) : UseCaseResult<Nothing>()
}