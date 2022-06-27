package com.rf.bandmeets.home.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rf.bandmeets.core.ui.components.BandMeetsAppBar
import com.rf.bandmeets.core.ui.components.CardTest
import com.rf.bandmeets.core.ui.theme.BandMeetsTheme
import com.rf.bandmeets.navigation.BandMeetsBottomNav

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    viewState: HomeViewState,
    onBackPressed: () -> Unit,
) {
    BandMeetsTheme {
        Scaffold(

            topBar = {
                BandMeetsAppBar()
            },
            content = {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
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
            bottomBar = { BandMeetsBottomNav() },

            )

    }


}


@Composable
private fun MyToolBar(
) {

}

@Preview(
    name = "Home Preview"
)
@Composable
fun HomePreview() {
    HomeContent(viewState = HomeViewState.Initial, onBackPressed = {})
}