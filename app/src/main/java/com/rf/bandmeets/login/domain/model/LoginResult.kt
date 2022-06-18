package com.rf.bandmeets.login.domain.model

/**
 * A collection of possible results for an attempt to login the user.
 */
sealed class LoginResult {

    object Success : LoginResult()

    sealed class Failure : LoginResult() {
        object InvalidCredentials : Failure()
        object Unknown : Failure()
        data class EmptyCredentials(
            val emptyEmail: Boolean,
            val emptyPassword: Boolean,
        ) : Failure()
    }
}