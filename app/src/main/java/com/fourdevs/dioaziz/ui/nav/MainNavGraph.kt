package com.fourdevs.dioaziz.ui.nav

import android.annotation.SuppressLint
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.fourdevs.dioaziz.ui.components.History
import com.fourdevs.dioaziz.ui.components.Home
import com.fourdevs.dioaziz.ui.components.PassportForm
import com.fourdevs.dioaziz.ui.components.Settings
import com.fourdevs.dioaziz.ui.components.ShareScreen
import com.fourdevs.dioaziz.viewmodels.MainViewModel

@SuppressLint("ComposableNavGraphInComposeScope")
fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController,
    viewModel: MainViewModel
) {
    // Define a navigation graph with 'MainNav' as the parent
    navigation(
        startDestination = AppScreen.Home.route,
        route = AppScreen.MainNav.route
    ) {
        // Define composable destinations as children of MainNav
        composable(AppScreen.Home.route) {
            Home(navController, viewModel)
        }
        composable(AppScreen.Application.route) {
            PassportForm(navController, viewModel)
        }
        composable(AppScreen.History.route) {
            History(navController, viewModel)
        }
        composable(AppScreen.Settings.route) {
            Settings(navController, viewModel)
        }
        composable(AppScreen.Share.route) {
            ShareScreen(navController, viewModel)
        }
    }
}