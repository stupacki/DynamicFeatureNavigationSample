package com.stupacki.sample.app.navigation.home

import androidx.navigation.NavController
import com.stupacki.sample.app.navigation.R
import com.stupacki.sample.app.navigation.main.provider.BottomNavProvider

object HomeNavigation {

    fun navigateBack(navController: NavController) {
        navController.navigateUp()
    }

    fun navigateToHome(navController: NavController) {
        navController.navigate(R.id.toHome)
        BottomNavProvider.showBottomNav()
    }

    fun navigateToHomeDetail(navController: NavController) {
        navController.navigate(R.id.toHomeDetail)
        BottomNavProvider.hideBottomNav()
    }
}

