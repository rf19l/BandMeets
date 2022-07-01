package com.rf.bandmeets.core.ui.components

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rf.bandmeets.core.ui.theme.BandMeetsTheme

@Composable
fun BandMeetsSpinner(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    strokeWidth: Dp = 8.dp,

) {
    BandMeetsTheme {
        CircularProgressIndicator(
            modifier,
            color,
            strokeWidth,
        )
    }

}