package com.stupacki.sample.app.navigation.home

import androidx.fragment.app.Fragment
import com.stupacki.sample.app.navigation.R
import com.stupacki.sample.app.navigation.common.Navigator

interface HomeNavigator : Navigator {

    fun Fragment.navigateBack() {
        getNavController(this).navigateUp()
    }

    fun Fragment.navigateToHome() {
        getNavController(this).navigate(R.id.toHome)
    }

    fun Fragment.navigateToHomeDetail() {
        getNavController(this).navigate(R.id.toHomeDetail)
    }
}

