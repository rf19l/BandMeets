package com.rf.bandmeets.core.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rf.bandmeets.R
import com.rf.bandmeets.core.ui.theme.BandMeetsTheme

@Composable
fun BandMeetsUserCard(){
    Box(
        modifier = Modifier.fillMaxSize(.9f),
        contentAlignment = Alignment.Center,
    ){
        Column(
            Modifier
                .background(
                    color=MaterialTheme.colorScheme.primaryContainer,
                    shape = MaterialTheme.shapes.extraLarge,
                )
                .padding(8.dp)
                .align(Alignment.TopCenter)

        ){
            Image(
                painterResource(id = R.drawable.avatar ),
                contentDescription = "User Avatar",
                modifier = Modifier.fillMaxSize(.7f)
            )
            Text("Text")
            Row(
                modifier = Modifier
                    .padding(10.dp)

            ) {
                Text(
                    text= "Name",
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(text = "Info",
                    color = MaterialTheme.colorScheme.onPrimaryContainer)
                
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
            BandMeetsUserCard()

}