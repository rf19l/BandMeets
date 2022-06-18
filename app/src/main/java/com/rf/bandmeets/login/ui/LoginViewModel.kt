package com.rf.bandmeets.login.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHost
import com.rf.bandmeets.login.domain.model.Credentials
import com.rf.bandmeets.login.domain.model.Email
import com.rf.bandmeets.login.domain.model.LoginResult
import com.rf.bandmeets.login.domain.model.Password
import com.rf.bandmeets.login.domain.usecase.CredentialsLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val credentialsLoginUseCase: CredentialsLoginUseCase,
    ): ViewModel() {
    private val _viewState: MutableStateFlow<LoginViewState> =
        MutableStateFlow(LoginViewState.Initial)
    val viewState: StateFlow<LoginViewState> = _viewState


    fun emailChanged(email: String) {
        val currentCredentials = _viewState.value.credentials
        val currentPasswordErrorMessage =
            (_viewState.value as? LoginViewState.Active)?.passwordInputErrorMessage

        _viewState.value = LoginViewState.Active(
            credentials = currentCredentials.withUpdatedEmail(email),
            emailInputErrorMessage = null,
            passwordInputErrorMessage = currentPasswordErrorMessage,
        )
    }

    fun passwordChanged(password: String) {
        val currentCredentials = _viewState.value.credentials
        val currentEmailErrorMessage =
            (_viewState.value as? LoginViewState.Active)?.emailInputErrorMessage

        _viewState.value = LoginViewState.Active(
            credentials = currentCredentials.withUpdatedPassword(password),
            passwordInputErrorMessage = null,
            emailInputErrorMessage = currentEmailErrorMessage,
        )
    }

    fun loginButtonClicked() {
        _viewState.value = LoginViewState.Completed
        /*
               val currentCredentials = _viewState.value.credentials
               _viewState.value = LoginViewState.Submitting(
                   credentials = currentCredentials,
               )

               viewModelScope.launch {
                   val loginResult = credentialsLoginUseCase.login(currentCredentials)

                   handleLoginResult(loginResult, currentCredentials)


        }
         */
    }

    fun signUpButtonClicked() {
        TODO()
    }

    private fun Credentials.withUpdatedEmail(email: String): Credentials {
        return this.copy(email = Email(email))
    }

    private fun Credentials.withUpdatedPassword(password: String): Credentials {
        return this.copy(password = Password(password))
    }

    private fun LoginResult.Failure.EmptyCredentials.toLoginViewState(credentials: Credentials): LoginViewState {
        return LoginViewState.Active(
            credentials = credentials,
            emailInputErrorMessage = "test",
            passwordInputErrorMessage = "test"
        )
    }

    private fun handleLoginResult(
        loginResult: LoginResult,
        currentCredentials: Credentials,
    ) {
        _viewState.value = when (loginResult) {
            is LoginResult.Failure.InvalidCredentials -> {
                LoginViewState.SubmissionError(
                    credentials = currentCredentials,
                    errorMessage = "test",
                )
            }
            is LoginResult.Failure.Unknown -> {
                LoginViewState.SubmissionError(
                    credentials = currentCredentials,
                    errorMessage = "test",
                )
            }
            is LoginResult.Failure.EmptyCredentials -> {
                loginResult.toLoginViewState(currentCredentials)
            }
            is LoginResult.Success -> {
                LoginViewState.Completed
            }
        }
    }
}
