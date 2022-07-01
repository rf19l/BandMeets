package com.rf.bandmeets.core.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rf.bandmeets.R
import com.rf.bandmeets.core.ui.theme.BandMeetsTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BandMeetsUserCard() {
    BandMeetsTheme {
        Card(
            elevation = CardDefaults.cardElevation(4.dp, 4.dp, 4.dp, 4.dp, 4.dp, 4.dp),
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(8.dp)
                .border(
                    BorderStroke(4.dp, MaterialTheme.colorScheme.primaryContainer),
                    MaterialTheme.shapes.medium
                ),
            shape = MaterialTheme.shapes.medium,

            ) {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = CenterHorizontally
            ) {
                Image(
                    painterResource(id = R.drawable.avatar),
                    contentDescription = "User Avatar",
                    modifier = Modifier
                        .clip(CircleShape)
                        .align(CenterHorizontally)
                        .fillMaxWidth(.5f),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Name",
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineSmall


                )
            }
        }
    }

}


@Preview(
    name = "User Card",
)
@Composable
@Suppress("UnusedPrivateMember")
private fun CardViewPreview() {
    Surface {
        BandMeetsUserCard()
    }
}