package com.stupacki.sample.app.navigation.notifications

import androidx.fragment.app.Fragment
import com.stupacki.sample.app.navigation.R
import com.stupacki.sample.app.navigation.common.Navigator
import com.stupacki.sample.app.navigation.main.provider.BottomNavProvider

interface NotificationsNavigator : Navigator {

    fun Fragment.toHomeFeature() {
        BottomNavProvider.showBottomNav()
        getNavController(this).navigate(R.id.toHomeFeature)
    }
}
