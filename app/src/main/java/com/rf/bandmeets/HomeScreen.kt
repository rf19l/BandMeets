package com.rf.bandmeets

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController){
    Button(onClick = {navController.navigate(Screen.SplashScreen.route)}){
        Text(text="To Splash Screen")
    }

}