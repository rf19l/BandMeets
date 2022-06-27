package com.rf.bandmeets.core.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.rf.bandmeets.R
import com.rf.bandmeets.core.ui.theme.BandMeetsTheme

@Composable
fun BandMeetsAppBar() {
    BandMeetsTheme {
        SmallTopAppBar(
            title = {
                Text(
                    text = "Title",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleMedium
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = {},
                    content = {
                        Icon(
                            painter = painterResource(R.drawable.ic_baseline_menu_24),
                            contentDescription = "TODO",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                )
            }
        )
    }

}

@Preview
@Composable
fun AppBarPreview() {
    BandMeetsAppBar()
}

/*
val toolbarHeight = 40.dp
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

 */