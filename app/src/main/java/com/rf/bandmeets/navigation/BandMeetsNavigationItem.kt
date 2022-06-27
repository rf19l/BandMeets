package com.rf.bandmeets.navigation

import com.rf.bandmeets.R

sealed class BandMeetsNavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : BandMeetsNavigationItem(
        route = "TODO",
        icon = R.drawable.ic_baseline_home_24,
        title = "Home"
    )

    object Chat : BandMeetsNavigationItem(
        route = "TODO",
        icon = R.drawable.ic_baseline_chat_24,
        title = "Chat"
    )

    object Profile : BandMeetsNavigationItem(
        route = "TODO",
        icon = R.drawable.ic_baseline_account_box_24,
        title = "Chat"
    )
}
