package com.rf.bandmeets.home.ui

import androidx.activity.OnBackPressedCallback
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
import com.rf.bandmeets.core.ui.Screen
import com.rf.bandmeets.home.ui.HomeViewState
import com.rf.bandmeets.navigation.NavigationUtils

@Composable
fun HomeContent(
    viewState: HomeViewState,
    onBackPressed: () -> Unit,
) {
    Scaffold(topBar = {
        TopAppBar(elevation = 5.dp) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back",
                    modifier = Modifier.clickable {
                       onBackPressed()
                    })
                Spacer(modifier = Modifier.width(25.dp))

                Text(
                    text = "Home",
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }) {
        Button(onClick = { onBackPressed() }) {
            Text(text = "To Home Screen")

        }
    }
}