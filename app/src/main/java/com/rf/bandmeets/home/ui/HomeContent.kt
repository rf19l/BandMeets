package com.rf.bandmeets.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rf.bandmeets.core.ui.components.BandMeetsAppBar
import com.rf.bandmeets.core.ui.components.BandMeetsUserCard
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
                Alignment.CenterHorizontally
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = CenterHorizontally
                ) {
                    Box(modifier = Modifier.weight(.1f, true))
                    Box(
                        modifier = Modifier
                            .padding(it)
                            .weight(.5f, true)
                            .align(CenterHorizontally)
                            .padding(20.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                        BandMeetsUserCard()
                    }
                    Box(modifier = Modifier.weight(.1f, true))
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