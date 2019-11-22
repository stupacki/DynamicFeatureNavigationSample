package com.stupacki.sample.app.navigation.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.stupacki.sample.app.navigation.R
import com.stupacki.sample.app.navigation.main.extensions.setupNavigationVisibility
import kotlinx.android.synthetic.main.activity_main_navigation.*

open class MainNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_navigation)

        val navigation = findNavController(R.id.mainNavHost)

        bottomNavView.setupWithNavController(navigation)
        bottomNavView.setupNavigationVisibility(navigation)
        bottomNavView.setOnNavigationItemReselectedListener { Unit }
    }
}


