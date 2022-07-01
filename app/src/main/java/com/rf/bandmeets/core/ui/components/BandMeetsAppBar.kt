package com.rf.bandmeets.core.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rf.bandmeets.R
import com.rf.bandmeets.core.ui.theme.BandMeetsTheme

@Composable
fun BandMeetsAppBar() {
    BandMeetsTheme {
        SmallTopAppBar(
            title = {
                Text(
                    text = "Title",
                    //color = MaterialTheme.colorScheme.onSurface,
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
                            //tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                )
            },
            modifier = Modifier.border(
                BorderStroke(2.dp, MaterialTheme.colorScheme.primaryContainer)
            ),
        )
    }

}

@Preview
@Composable
fun AppBarPreview() {
    BandMeetsAppBar()
}