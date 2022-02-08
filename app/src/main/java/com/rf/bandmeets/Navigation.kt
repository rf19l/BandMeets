package com.rf.bandmeets

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController=navController, startDestination = Screen.SplashScreen.route){
        composable(route=Screen.SplashScreen.route){
            SplashScreen(navController= navController)
        }
        composable(route=Screen.MainScreen.route){
            HomeScreen(navController=navController)
        }
    }

}