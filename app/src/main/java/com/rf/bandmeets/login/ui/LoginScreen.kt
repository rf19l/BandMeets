package com.rf.bandmeets.login.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.rf.bandmeets.core.ui.Screen

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel<LoginViewModel>()
) {
    val viewState = viewModel.viewState.collectAsState()
    val context = LocalContext.current

    DisposableEffect(viewState.value) {
        if (viewState.value is LoginViewState.Completed) {
            navController.navigate(Screen.MainScreen.route)
        }

        onDispose { }
    }
    LoginContent(
        viewState = viewState.value,
        onEmailChanged = viewModel::emailChanged,
        onPasswordChanged = viewModel::passwordChanged,
        onLoginClicked = viewModel::loginButtonClicked,
        onSignUpClicked = viewModel::signUpButtonClicked
    )


}
