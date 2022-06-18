package com.rf.bandmeets.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rf.bandmeets.home.ui.HomeScreen
import com.rf.bandmeets.core.ui.Screen
import com.rf.bandmeets.login.ui.LoginScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            HomeScreen(navController = navController)
        }
    }

}