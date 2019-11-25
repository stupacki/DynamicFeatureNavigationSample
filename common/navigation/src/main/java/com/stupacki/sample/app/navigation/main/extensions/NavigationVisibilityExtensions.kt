package com.stupacki.sample.app.navigation.main.extensions

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.ref.WeakReference

fun BottomNavigationView.setupNavigationVisibility(navigation: NavController) {
    navigation.addOnDestinationChangedListener(
        NavigationDestinationVisibilityProvider(
            this
        )
    )
}

private fun BottomNavigationView.open() {
    visibility = View.VISIBLE
}

private fun BottomNavigationView.close() {
    visibility = View.GONE
}

class NavigationDestinationVisibilityProvider(bottomNavigationView: BottomNavigationView) :
    NavController.OnDestinationChangedListener {

    private val navigationView: WeakReference<BottomNavigationView> =
        WeakReference(bottomNavigationView)

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        when (shouldShowNavigation(destination)) {
            true -> navigationView.get()?.open()
            else -> navigationView.get()?.close()
        }
    }

    private fun shouldShowNavigation(destination: NavDestination): Boolean =
        isStartDestination(destination) && isDestinationInBottomNavigation(destination)

    private fun isStartDestination(destination: NavDestination) =
        destination.id == destination.parent?.startDestination

    private fun isDestinationInBottomNavigation(destination: NavDestination): Boolean =
        navigationView.get()?.let { bottomNavView ->
            (0 until bottomNavView.menu.size()).mapNotNull { index ->
                checkDestination(bottomNavView.menu.getItem(index), destination)
            }
                .contains(true)
        } ?: false

    private fun checkDestination(item: MenuItem, destination: NavDestination?): Boolean =
        when (destination?.id != item.itemId && destination?.parent != null) {
            false -> checkDestination(item, destination?.parent)
            else -> destination?.parent?.id == item.itemId
        }
}
