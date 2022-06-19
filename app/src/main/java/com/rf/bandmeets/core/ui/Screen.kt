package com.rf.bandmeets.core.ui

sealed class Screen(val route: String){
    object HomeScreen: Screen("home_screen")
    object LoginScreen: Screen("login_screen")

}