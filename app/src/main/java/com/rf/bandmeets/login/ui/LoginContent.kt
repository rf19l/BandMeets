package com.rf.bandmeets.login.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun LoginContent(
    viewState: LoginViewState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
) {
    Scaffold(topBar = {
        TopAppBar(elevation = 5.dp) {
            Row(horizontalArrangement = Arrangement.Start) {
                Text(
                    text = "Login",
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }) {
        Button(onClick = { onLoginClicked() }) {
            Text(text = "To Home Screen")
        }
    }
}