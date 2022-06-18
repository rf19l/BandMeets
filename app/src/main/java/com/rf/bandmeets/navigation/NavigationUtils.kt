package com.rf.bandmeets.navigation

import androidx.navigation.NavController

object NavigationUtils {
    fun popBack(navController: NavController) {
        navController.popBackStack()
    }
}