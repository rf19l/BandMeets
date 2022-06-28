package com.rf.bandmeets.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rf.bandmeets.R
import com.rf.bandmeets.core.ui.theme.BandMeetsTheme

@Composable
fun BandMeetsUserCard(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize(.9f)
            .wrapContentSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            Modifier
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = MaterialTheme.shapes.extraLarge,
                )
                .padding(8.dp)
                .align(Alignment.TopCenter),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painterResource(id = R.drawable.avatar),
                contentDescription = "User Avatar",
                modifier = Modifier
                    .fillMaxWidth(.7f)
                    .clip(CircleShape)
                    .background(color = Color.Transparent, shape = CircleShape),

                )
            Text("Name", color = MaterialTheme.colorScheme.onPrimaryContainer)
            Text(
                text = "Name", color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }


    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardTest() {
    BandMeetsTheme{
        Card(
            elevation = CardDefaults.cardElevation(4.dp, 4.dp, 4.dp, 4.dp, 4.dp, 4.dp),
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = MaterialTheme.shapes.medium,
                )
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(8.dp),
            shape = MaterialTheme.shapes.medium,

            ) {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(id = R.drawable.avatar),
                    contentDescription = "User Avatar",
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = MaterialTheme.shapes.large
                        )
                        .align(CenterHorizontally)
                        .fillMaxWidth(.5f),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Name", color = MaterialTheme.colorScheme.onPrimaryContainer,
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

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    name = "Standard Card"
)
@Composable
fun Test() {
    Surface(modifier = Modifier.fillMaxSize()) {
        CardTest()
    }

}