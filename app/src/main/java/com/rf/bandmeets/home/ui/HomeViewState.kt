package com.rf.bandmeets.home.ui

import com.rf.bandmeets.home.domain.model.User
import com.rf.bandmeets.login.domain.model.Credentials
import com.rf.bandmeets.login.ui.LoginViewState

sealed class HomeViewState (
    open val inputsEnabled: Boolean = true,
    open val user:User
    ) {
    /**
     * The initial state of the screen with nothing input.
     */
    object Initial : HomeViewState(
        user = User()
    )

    data class LoggingOut(
        override val user: User,
    ) : HomeViewState(
        user = user,
        inputsEnabled = false
    )

    object BackPressed: HomeViewState(
        user = User(),
        inputsEnabled = false
    )

}