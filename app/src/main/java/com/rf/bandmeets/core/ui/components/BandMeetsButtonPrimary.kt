package com.rf.bandmeets.core.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import com.rf.bandmeets.R
import com.rf.bandmeets.core.ui.theme.BandMeetsTheme
import com.rf.bandmeets.core.ui.theme.ButtonShape

@Composable
fun BandMeetsButtonPrimary(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    BandMeetsTheme {
        Button(
            onClick = onClick,
            shape = ButtonShape,
            modifier = modifier
                .height(dimensionResource(id = R.dimen.button_height))
                .fillMaxWidth(),
            enabled = enabled
        ) {
            Text(
                text = text.toUpperCase(Locale.current)
            )
        }
    }

}

@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
@Suppress("UnusedPrivateMember")
private fun PrimaryButtonPreview() {
    BandMeetsButtonPrimary(
        text = "Primary button",
        onClick = {},
    )
}

@Preview(
    name = "Night Mode - Disabled",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Day Mode - Disabled",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
@Suppress("UnusedPrivateMember")
private fun DisabledPrimaryButtonPreview() {
    BandMeetsButtonPrimary(
        text = "Primary button",
        onClick = {},
        enabled = false,
    )
}