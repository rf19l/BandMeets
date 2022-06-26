package com.rf.bandmeets.home.ui

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rf.bandmeets.R
import com.rf.bandmeets.core.ui.components.CardTest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    viewState: HomeViewState,
    onBackPressed: () -> Unit,
) {
    Scaffold(

        topBar = {
            MyToolBar()
        },
        content = {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
            ) {
                Box(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxWidth(.7f)
                        .fillMaxHeight(.5f),
                    contentAlignment = Alignment.Center
                ) {
                    CardTest()
                }
            }
        },
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colorScheme.primary
            ) {
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = R.drawable.ic_android_black_24dp),
                            contentDescription = "item.title"
                        )
                    },
                    label = { Text(text = "item.title") },
                    selectedContentColor = MaterialTheme.colorScheme.primary,
                    unselectedContentColor = MaterialTheme.colorScheme.inversePrimary,
                    alwaysShowLabel = true,
                    selected = true,
                    onClick = {}
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = R.drawable.ic_android_black_24dp),
                            contentDescription = "item.title"
                        )
                    },
                    label = { Text(text = "item.title") },
                    selectedContentColor = MaterialTheme.colorScheme.primary,
                    unselectedContentColor = MaterialTheme.colorScheme.inversePrimary,
                    alwaysShowLabel = true,
                    selected = false,
                    onClick = {}
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = R.drawable.ic_android_black_24dp),
                            contentDescription = "item.title"
                        )
                    },
                    label = { Text(text = "item.title") },
                    selectedContentColor = MaterialTheme.colorScheme.primary,
                    unselectedContentColor = MaterialTheme.colorScheme.inversePrimary,
                    alwaysShowLabel = true,
                    selected = false,
                    onClick = {}
                )

            }

        },

        )

}


@Composable
private fun MyToolBar(
) {
    val toolbarHeight = 84.dp

    Surface(
        color = MaterialTheme.colorScheme.primary,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .statusBarsPadding()
                .height(toolbarHeight)
        ) {
            IconButton(
                onClick = { },
            ) {
                Icon(
                    Icons.Default.KeyboardArrowLeft,
                    contentDescription = ("test"),
                    modifier = Modifier
                        .size(toolbarHeight),
                )
            }

            Crossfade(
                targetState = "title",
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .clickable(
                        onClick = { },
                    )
                    .weight(1F)
                    .height(toolbarHeight),
            ) { title ->
                Box(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Text(
                        text = title,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Center),
                    )
                }
            }

            IconButton(
                onClick = {},
                modifier = Modifier
                    .testTag("test tag"),
            ) {
                Icon(
                    Icons.Default.KeyboardArrowRight,
                    contentDescription = ("test"),
                    modifier = Modifier
                        .size(toolbarHeight),
                )
            }
        }
    }
}

@Preview(
    name = "Home Preview"
)
@Composable
fun HomePreview() {
    HomeContent(viewState = HomeViewState.Initial, onBackPressed = {})
}