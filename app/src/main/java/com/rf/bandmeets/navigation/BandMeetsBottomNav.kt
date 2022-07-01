package com.rf.bandmeets.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.rf.bandmeets.core.ui.theme.BandMeetsTheme

@Composable
fun BandMeetsBottomNav() {
    BandMeetsTheme {
        val items = listOf(
            BandMeetsNavigationItem.Chat,
            BandMeetsNavigationItem.Home,
            BandMeetsNavigationItem.Profile
        )
        NavigationBar {
            items.forEach { item ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title,
                        )
                    },
                    onClick = {},
                    selected = item.title == BandMeetsNavigationItem.Home.title,
                    alwaysShowLabel = true,
                    label = { Text(text = item.title) }
                )
            }
        }

    }

}

@Preview
@Composable
fun NavPreview() {
    BandMeetsBottomNav()
}