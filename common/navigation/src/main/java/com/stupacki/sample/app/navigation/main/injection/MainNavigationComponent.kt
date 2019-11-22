package com.stupacki.sample.app.navigation.main.injection

import com.stupacki.sample.app.core.CoreApplication
import org.rewedigital.katana.Component

object MainNavigationComponent {

    operator fun invoke() = Component(
        modules = listOf(
            MainNavigationModule()
        ),
        dependsOn = listOf(
            CoreApplication.coreComponent
        )
    )
}