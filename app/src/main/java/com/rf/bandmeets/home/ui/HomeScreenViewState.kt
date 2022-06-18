package com.rf.bandmeets.home.ui

import com.rf.bandmeets.login.domain.model.Credentials

sealed class HomeScreenViewState (
    open val inputsEnabled: Boolean = true,
    open val isGuest: Boolean = true
        ) {

}