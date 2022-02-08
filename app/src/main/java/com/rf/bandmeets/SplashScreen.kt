package com.rf.bandmeets

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun SplashScreen(navController: NavController){
    Button(onClick = {navController.navigate(Screen.MainScreen.route)}){
        Text(text="To Home Screen")
    }

}