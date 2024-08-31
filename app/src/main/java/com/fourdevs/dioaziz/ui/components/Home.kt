package com.fourdevs.dioaziz.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.fourdevs.dioaziz.R
import com.fourdevs.dioaziz.ui.nav.AppScreen
import com.fourdevs.dioaziz.ui.theme.Blue80
import com.fourdevs.dioaziz.ui.theme.Green80
import com.fourdevs.dioaziz.ui.theme.Orange80
import com.fourdevs.dioaziz.ui.theme.Purple80
import com.fourdevs.dioaziz.utils.Constants
import com.fourdevs.dioaziz.viewmodels.MainViewModel

@Composable
fun Home(navController: NavHostController, viewModel: MainViewModel) {
    var progress by rememberSaveable { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Row {
                HomeCard(
                    onClick = {
                        progress = true
                    },
                    imageVector = Icons.Filled.Add,
                    text = Constants.KEY_ADD_NEW_BN,
                    modifier = Modifier.fillMaxWidth(0.5f),
                    containerColor = Blue80
                )
                HomeCard(
                    onClick = {
                        navController.navigate(AppScreen.History.route)
                    },
                    imageVector = Icons.AutoMirrored.Filled.List,
                    text = Constants.KEY_HISTORY_BN,
                    modifier = Modifier.fillMaxWidth(1f),
                    containerColor = Green80
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                HomeCard(
                    onClick = {
                        navController.navigate(AppScreen.Settings.route)
                    },
                    imageVector = Icons.Filled.Settings,
                    text = Constants.KEY_SETTINGS_BN,
                    modifier = Modifier.fillMaxWidth(0.5f),
                    containerColor = Orange80
                )
            }
        }

        if(progress) {
            CustomProgressIndicator()
            LaunchedEffect(Unit) {
                navController.navigate(AppScreen.Application.route)
            }
        }
    }
}
