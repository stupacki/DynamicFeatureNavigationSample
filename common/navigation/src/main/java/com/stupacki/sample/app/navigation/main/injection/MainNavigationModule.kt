package com.stupacki.sample.app.navigation.main.injection

import com.stupacki.sample.app.navigation.main.viewmodel.MainNavigationViewModel
import org.rewedigital.katana.Module
import org.rewedigital.katana.androidx.viewmodel.viewModel

object MainNavigationModule {

    operator fun invoke() = Module {

        viewModel { MainNavigationViewModel().apply(MainNavigationViewModel::initialize) }
    }
}