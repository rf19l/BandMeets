package com.rf.bandmeets.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SplashScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(elevation = 5.dp) {
            Row(horizontalArrangement = Arrangement.Start) {
                Spacer(modifier = Modifier.width(25.dp))

                Text(
                    text = "Login",
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }) {
        Button(onClick = { navController.navigate(Screen.MainScreen.route) }) {
            Text(text = "To Home Screen")
        }
        /*    TopAppBar(elevation = 5.dp) {
                Row(horizontalArrangement = Arrangement.Start){
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow Back",
                        modifier=Modifier.clickable{
                    })
                    Spacer(modifier = Modifier.width(25.dp))

                    Text(
                        text="Login",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }

         */
    }

    /*

     */

}