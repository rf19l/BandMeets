package com.rf.bandmeets.login.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.rf.bandmeets.core.ui.Screen

@Destination(start=true)
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator,
    viewModel: LoginViewModel = hiltViewModel<LoginViewModel>()
) {
    val viewState = viewModel.viewState.collectAsState()
    val context = LocalContext.current

    DisposableEffect(viewState.value) {
        if (viewState.value is LoginViewState.Completed) {
            navigator.navigate(Screen.HomeScreen.route){
                popUpToRoute
            }
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
