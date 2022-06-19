package com.rf.bandmeets.core.ui

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/**
 * This is a sealed class that contains all of the different ways text can be presented to the UI.
 */
sealed class UiTextUtils {data class StringText(val value: String) : UiTextUtils()

    data class ResourceText(@StringRes val value: Int) : UiTextUtils()
}

/**
 * Evaluates the value of this [UiTextUtils] based on its type.
 *
 * @param[context] If necessary, use this to evaluate a string resource.
 */
fun UiTextUtils.getString(context: Context): String {
    return when (this) {
        is UiTextUtils.StringText -> this.value
        is UiTextUtils.ResourceText -> context.getString(this.value)
    }
}

/**
 * A helper function that allows to get strings from a [Composable] context.
 */
@Composable
fun UiTextUtils.getString(): String {
    return this.getString(LocalContext.current)}