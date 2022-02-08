package com.rf.bandmeets

sealed class Screen(val route: String){
    object MainScreen: Screen("main_screen")
    object SplashScreen: Screen("login_screen")

}