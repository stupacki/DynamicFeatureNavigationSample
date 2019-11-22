package com.stupacki.sample.app.navigation.main.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.stupacki.sample.app.navigation.R
import kotlinx.android.synthetic.main.activity_main_navigation.*

open class MainNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_navigation)

        val navigation = findNavController(R.id.mainNavHost)

        bottomNavView.setupWithNavController(navigation)
        bottomNavView.setOnNavigationItemReselectedListener { Unit }
        navigation.addOnDestinationChangedListener(onDestinationChangedListener)
    }

    private fun shouldHideNavigation(controller: NavController, destination: NavDestination): Boolean {
        val destinationGraph = destination.parent
        val isGraphIncluded = controller.graph.contains(destinationGraph)

        return destinationGraph?.startDestination?.let { id ->
            val isStartDestination = id == destination.id

            return !isStartDestination || !isGraphIncluded
        } ?: false
    }

    private fun hideBottomNav() {
        bottomNavView.visibility = View.GONE
    }

    private fun showBottomNav() {
        bottomNavView.visibility = View.VISIBLE
    }

    private val onDestinationChangedListener = NavController.OnDestinationChangedListener { navController, navDestination, _ ->
        when ( shouldHideNavigation(navController, navDestination) ) {
            true -> hideBottomNav()
            else -> showBottomNav()
        }
    }
}


