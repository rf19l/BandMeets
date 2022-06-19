package com.rf.bandmeets.login.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
    Scaffold(
        topBar = {
            TopAppBar(elevation = 5.dp) {
                Row(horizontalArrangement = Arrangement.Start) {
                    Text(
                        text = "Login",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Button(
                    onClick = { onLoginClicked() },
                    modifier = Modifier.padding(16.dp)

                    ) {
                    Text(text = "To Home Screen")

                }
            }



        },
        bottomBar = {
            BottomAppBar(elevation = 5.dp){
                Row(horizontalArrangement = Arrangement.Start){
                    Text(text = "This is a test")
                }
            }
        }
    )
}