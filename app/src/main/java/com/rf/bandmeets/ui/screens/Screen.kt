package com.rf.bandmeets.ui.screens

sealed class Screen(val route: String){
    object MainScreen: Screen("main_screen")
    object SplashScreen: Screen("login_screen")

}