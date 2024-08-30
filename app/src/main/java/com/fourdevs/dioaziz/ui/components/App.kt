package com.fourdevs.dioaziz.ui.components

import android.widget.Toast
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fourdevs.dioaziz.R
import com.fourdevs.dioaziz.ui.nav.AppScreen
import com.fourdevs.dioaziz.ui.nav.mainNavGraph
import com.fourdevs.dioaziz.utils.Constants
import com.fourdevs.dioaziz.viewmodels.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(viewModel: MainViewModel) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    var title by rememberSaveable { mutableStateOf("") }
    var destinationNow by rememberSaveable { mutableStateOf("back") }
    val content = LocalContext.current

    viewModel.getPassportData(enrollId = "23")


    when (currentDestination?.route) {
        AppScreen.Home.route -> {
            title = Constants.KEY_HOME_BN
            destinationNow = AppScreen.Home.route
        }

        AppScreen.Settings.route -> {
            title = Constants.KEY_SETTINGS_BN
            destinationNow = AppScreen.Settings.route
        }

        AppScreen.History.route -> {
            title = Constants.KEY_HISTORY_BN
            destinationNow = AppScreen.Settings.route
        }

        AppScreen.Application.route -> {
            title = Constants.KEY_ADD_NEW_BN
            destinationNow = AppScreen.Settings.route
        }

        AppScreen.Share.route -> {
            title = Constants.KEY_PREVIEW_BN
            destinationNow = AppScreen.Share.route
        }

        else -> {
            destinationNow = "back"
        }
    }

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp),
                style = MaterialTheme.typography.titleMedium
            )
        }, navigationIcon = {
            IconButton(
                onClick = {
                    if (destinationNow == AppScreen.Home.route) {
                        Toast.makeText(content, Constants.KEY_HOME_BN, Toast.LENGTH_SHORT).show()
                    } else {
                        navController.navigate(AppScreen.MainNav.route) {
                            popUpTo(AppScreen.MainNav.route) { inclusive = true }
                        }
                    }
                }) {
                Icon(
                    imageVector = if (destinationNow == AppScreen.Home.route)
                        Icons.Filled.Home
                    else Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Icon"
                )
            }
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
        )
    }) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            NavHost(
                navController = navController, startDestination = AppScreen.MainNav.route,
                enterTransition = {
                    fadeIn(
                        animationSpec = tween(
                            300, easing = LinearEasing
                        )
                    ) + slideIntoContainer(
                        animationSpec = tween(300, easing = EaseIn),
                        towards = AnimatedContentTransitionScope.SlideDirection.Start
                    )
                }
            ) {
                mainNavGraph(navController, viewModel)
            }
        }
    }
}

