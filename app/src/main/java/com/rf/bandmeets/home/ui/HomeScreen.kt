package com.rf.bandmeets.home.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.rf.bandmeets.navigation.NavigationUtils
import com.rf.bandmeets.core.ui.Screen
import com.rf.bandmeets.destinations.LoginScreenDestination
import com.rf.bandmeets.login.ui.LoginViewModel
import com.rf.bandmeets.login.ui.LoginViewState

@Destination(start=false)
@Composable
fun HomeScreen(
    navigator:DestinationsNavigator,
    viewModel: HomeScreenViewModel = hiltViewModel<HomeScreenViewModel>()
) {
    val viewState = viewModel.viewState.collectAsState()
    val context = LocalContext.current

    DisposableEffect(viewState.value) {
        if (viewState.value is HomeViewState.BackPressed) {
            //TODO Figure out why pop back is not working as expected
           navigator.navigate(LoginScreenDestination){
               popUpToRoute
           }
        }

        onDispose { }
    }

    HomeContent(
        viewState = viewState.value,
        onBackPressed = viewModel::onBackPressed,
    )

}