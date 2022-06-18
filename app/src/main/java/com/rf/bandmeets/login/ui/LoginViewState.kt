package com.rf.bandmeets.login.ui

import com.rf.bandmeets.login.domain.model.Credentials

sealed class LoginViewState(
    open val credentials: Credentials,
    open val inputsEnabled: Boolean = true
) {

    /**
     * The initial state of the screen with nothing input.
     */
    object Initial : LoginViewState(
        credentials = Credentials()
    )

    /**
     * The state of the screen as the user is entering email information.
     */
    data class Active(
        override val credentials: Credentials,
        val emailInputErrorMessage: String? = null,
        val passwordInputErrorMessage: String? = null,
    ) : LoginViewState(
        credentials = credentials,
    )

    /**
     * The state of the screen as the user is attempting to login.
     */
    data class Submitting(
        override val credentials: Credentials,
    ) : LoginViewState(
        credentials = credentials,
        inputsEnabled = false,
    )

    /**
     * The state of the screen when there is an error logging in.
     */
    data class SubmissionError(
        override val credentials: Credentials,
        val errorMessage: String,
    ) : LoginViewState(
        credentials = credentials,
    )

    object Completed : LoginViewState(
        credentials = Credentials(),
        inputsEnabled = false,
    )
}