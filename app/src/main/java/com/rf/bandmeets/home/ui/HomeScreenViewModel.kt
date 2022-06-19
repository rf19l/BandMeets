package com.rf.bandmeets.home.ui

import androidx.lifecycle.ViewModel
import com.rf.bandmeets.login.domain.usecase.CredentialsLoginUseCase
import com.rf.bandmeets.login.ui.LoginViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
): ViewModel() {
    private val _viewState: MutableStateFlow<HomeViewState> =
        MutableStateFlow(HomeViewState.Initial)
    val viewState: StateFlow<HomeViewState> = _viewState

    fun onBackPressed(){
        _viewState.value = HomeViewState.BackPressed
    }
}
