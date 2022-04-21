package com.rf.bandmeets.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rf.bandmeets.navigation.NavigationUtils

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(elevation = 5.dp) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back",
                    modifier = Modifier.clickable {
                        NavigationUtils.popBack(navController)
                    })
                Spacer(modifier = Modifier.width(25.dp))

                Text(
                    text = "Home",
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }) {
        Button(onClick = { navController.navigate(Screen.SplashScreen.route) }) {
            Text(text = "To Home Screen")

        }
    }
}