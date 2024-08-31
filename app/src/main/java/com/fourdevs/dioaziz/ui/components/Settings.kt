package com.fourdevs.dioaziz.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.fourdevs.dioaziz.utils.Constants
import com.fourdevs.dioaziz.viewmodels.MainViewModel

@Composable
fun Settings(navController: NavHostController, viewModel: MainViewModel) {
    val localFocusManager = LocalFocusManager.current
    val isError by viewModel.isError.collectAsState()
    val investigationsOfficerName by viewModel.investigationsOfficerName.collectAsState()
    val branchName by viewModel.branchName.collectAsState()


    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
    ) {
        CustomInputField(
            text = Constants.KEY_INVESTIGATION_OFFICER_BN,
            value = investigationsOfficerName,
            onChange = { viewModel.updateInvestigationsOfficerName(it) },
            localFocusManager = localFocusManager,
            isError = isError
        )

        CustomInputField(
            text = Constants.KEY_BRANCH_BN,
            value = branchName,
            onChange = { viewModel.updateBranchName(it) },
            localFocusManager = localFocusManager,
            isError = isError
        )

        CustomButton(text = Constants.KEY_SAVE_BN) {
            viewModel.updateSettingData(investigationsOfficerName, branchName)
        }
    }


}
