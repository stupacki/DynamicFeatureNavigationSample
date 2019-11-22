package com.stupacki.sample.app.navigation.main.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.stupacki.sample.app.navigation.R
import com.stupacki.sample.app.navigation.main.injection.MainNavigationComponent
import com.stupacki.sample.app.navigation.main.viewmodel.BottomNavVisibleState
import com.stupacki.sample.app.navigation.main.viewmodel.MainNavigationViewModel
import kotlinx.android.synthetic.main.activity_main_navigation.*
import org.rewedigital.katana.androidx.viewmodel.viewModel

abstract class MainNavigationActivity : AppCompatActivity() {

    private val navController by lazy { findNavController(R.id.mainNavHost) }
    private val component by lazy { MainNavigationComponent() }

    private val viewModel by component.viewModel<MainNavigationViewModel>(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_navigation)

        navController.setGraph(R.navigation.navigation_main)

        bottomNavView.setupWithNavController(navController)
        bottomNavView.inflateMenu(R.menu.bottom_nav_menu)

        viewModel.bottomNavState.observe(this, Observer { onBottomNavStateChange(it) })
    }

    private fun onBottomNavStateChange(state: BottomNavVisibleState?) {
        when (state) {
            is BottomNavVisibleState.Hidden -> hideBottomNav()
            is BottomNavVisibleState.Shown -> showBottomNav()
        }
    }

    private fun hideBottomNav() {
        bottomNavView.visibility = View.GONE
    }

    private fun showBottomNav() {
        bottomNavView.visibility = View.VISIBLE
    }
}
