package com.stupacki.sample.app.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stupacki.sample.app.navigation.R
import com.stupacki.sample.app.navigation.main.extensions.setupNavigationVisibility

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_navigation)

        // Synthetic doesn't work cross-module!
        findViewById<BottomNavigationView>(R.id.bottomNavView).let { bottomNavView ->
            val navigation = findNavController(R.id.mainNavHost)

            bottomNavView.setupWithNavController(navigation)
            bottomNavView.setupNavigationVisibility(navigation)
            bottomNavView.setOnNavigationItemReselectedListener { Unit }
        }
    }
}
