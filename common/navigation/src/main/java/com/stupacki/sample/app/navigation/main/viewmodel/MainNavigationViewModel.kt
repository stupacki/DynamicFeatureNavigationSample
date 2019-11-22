package com.stupacki.sample.app.navigation.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stupacki.sample.app.navigation.main.provider.BottomNavProvider
import com.stupacki.sample.app.navigation.main.viewmodel.BottomNavVisibleState.Hidden
import com.stupacki.sample.app.navigation.main.viewmodel.BottomNavVisibleState.Shown

sealed class BottomNavVisibleState() {
    object Hidden : BottomNavVisibleState()
    object Shown : BottomNavVisibleState()
}

class MainNavigationViewModel : ViewModel() {

    private val _bottomNavState = MutableLiveData<BottomNavVisibleState?>()

    val bottomNavState = _bottomNavState

    val onHideBottomNav: () -> Unit
        get() = {
            when (_bottomNavState.value) {
                !is Hidden -> _bottomNavState.value = Hidden
            }
        }

    val onShowBottomNav: () -> Unit
        get() = {
            when (_bottomNavState.value) {
                !is Shown -> _bottomNavState.value = Shown
            }
        }

    fun initialize() {
        initBottomNavProvider()

        onShowBottomNav()
    }

    private fun initBottomNavProvider() {
        BottomNavProvider.hideBottomNav = onHideBottomNav
        BottomNavProvider.showBottomNav = onShowBottomNav
    }
}