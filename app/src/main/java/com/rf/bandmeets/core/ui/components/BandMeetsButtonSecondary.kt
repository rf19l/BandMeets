package com.rf.bandmeets.core.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults.textButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import com.rf.bandmeets.R
import com.rf.bandmeets.core.ui.theme.BandMeetsTheme
import com.rf.bandmeets.core.ui.theme.ButtonShape

@Composable
fun BandMeetsButtonSecondary(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    contentColor: Color = MaterialTheme.colorScheme.primary,
    enabled: Boolean = true
) {
    BandMeetsTheme {
        val buttonColors = textButtonColors(
            contentColor = contentColor,
        )
        TextButton(
            onClick = onClick,
            shape = ButtonShape,
            modifier = modifier
                .height(dimensionResource(id = R.dimen.button_height))
                .fillMaxWidth(),
            colors = buttonColors,
            enabled = enabled,
        ) {
            Text(
                text = text.toUpperCase(Locale.current),
            )
        }

    }
}

@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    group = "enabled",
)
@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    group = "enabled",
)
@Composable
@Suppress("UnusedPrivateMember")
private fun BandMeetsButtonSecondaryPreview() {
    Surface {
        BandMeetsButtonSecondary(
            text = "Primary button",
            onClick = {},
        )
    }
}

@Preview(
    name = "Night Mode - Disabled",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    group = "disabled",
)
@Preview(
    name = "Day Mode - Disabled",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    group = "disabled",
)
@Composable
@Suppress("UnusedPrivateMember")
private fun DisabledBandMeetsButtonSecondaryPreview() {
    Surface {
        BandMeetsButtonSecondary(
            text = "Primary button",
            onClick = {},
            enabled = false,
        )
    }
}