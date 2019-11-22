package com.stupacki.sample.app.navigation.notifications

import androidx.navigation.NavController
import com.stupacki.sample.app.navigation.main.MainNavigation

object NotificationsNavigation {

    fun toHomeFeature(navController: NavController) {
        MainNavigation.navigateToHomeFeature(navController)
    }
}