package com.stupacki.sample.app.navigation.home

import androidx.fragment.app.Fragment
import com.stupacki.sample.app.navigation.R
import com.stupacki.sample.app.navigation.common.Navigator
import com.stupacki.sample.app.navigation.main.provider.BottomNavProvider

interface HomeNavigator : Navigator {

    fun Fragment.navigateBack() {
        BottomNavProvider.showBottomNav()
        getNavController(this).navigateUp()
    }

    fun Fragment.navigateToHome() {
        BottomNavProvider.showBottomNav()
        getNavController(this).navigate(R.id.toHome)
    }

    fun Fragment.navigateToHomeDetail() {
        BottomNavProvider.hideBottomNav()
        getNavController(this).navigate(R.id.toHomeDetail)
    }
}

