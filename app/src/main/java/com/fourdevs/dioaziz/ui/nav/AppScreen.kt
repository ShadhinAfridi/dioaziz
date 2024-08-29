package com.fourdevs.dioaziz.ui.nav

enum class AppScreen(override val route: String) : Destinations {
    Home("home"),
    Application("application"),
    History("history"),
    Settings("settings"),
    MainNav("main"); // Parent NavGraph route
}