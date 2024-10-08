package com.fourdevs.dioaziz.ui.components

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.fourdevs.dioaziz.ui.nav.AppScreen
import com.fourdevs.dioaziz.utils.Constants
import com.fourdevs.dioaziz.viewmodels.MainViewModel

@SuppressLint("RememberReturnType")
@Composable
fun PassportForm(navController: NavHostController, viewModel: MainViewModel) {

    val localFocusManager = LocalFocusManager.current
    val context = LocalContext.current

    val addressChecked by viewModel.addressCheckedState.collectAsState()
    val fatherChecked by viewModel.fatherCheckedState.collectAsState()
    val motherChecked by viewModel.motherCheckedState.collectAsState()
    val openDialog by viewModel.openDialog.collectAsState()
    val isError by viewModel.isError.collectAsState()
    val permanentAddress by viewModel.permanentAddress.collectAsState("")
    val applicantMobileNo by viewModel.applicantMobileNo.collectAsState("")
    val permanentPost by viewModel.permanentPost.collectAsState("")
    val permanentThana by viewModel.permanentThana.collectAsState("")
    val permanentZilla by viewModel.permanentZilla.collectAsState("")
    val father by viewModel.father.collectAsState("")
    val mother by viewModel.mother.collectAsState("")

    var isClicked by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(
        addressChecked,
        fatherChecked,
        motherChecked,
        permanentAddress,
        permanentPost,
        permanentThana,
        permanentZilla,
        father,
        mother,
        applicantMobileNo
    ) {
        viewModel.updateCheckData()
    }

    if (openDialog) {
        OpenDialogDiFields(viewModel)
    }

    if(isError){
        Toast.makeText(context, Constants.KEY_ERROR_MESSAGE_BN, Toast.LENGTH_SHORT).show()
        viewModel.updateError(false)
    }


    LaunchedEffect(isClicked) {
        if(isClicked) {
            isClicked = false
            navController.navigate(AppScreen.Share.route)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 5.dp) // Add some padding to avoid overlap with the button
        ) {

            ApplicationFields(
                viewModel = viewModel,
                localFocusManager = localFocusManager
            )
            PersonalFields(
                viewModel = viewModel,
                localFocusManager = localFocusManager
            )
            PermanentAddressFields(
                viewModel = viewModel,
                localFocusManager = localFocusManager
            )
            PresentAddressFields(
                viewModel = viewModel,
                localFocusManager = localFocusManager
            )
            PersonOneFields(
                viewModel = viewModel,
                localFocusManager = localFocusManager
            )
            PersonTwoFields(
                viewModel = viewModel,
                localFocusManager = localFocusManager
            )

            Spacer(modifier = Modifier.height(50.dp)) // Add some space after the last form field
        }

        // Button placed at the bottom
        CustomButton(
            text = Constants.KEY_SAVE_BN,
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            isClicked = true
            viewModel.savePassportData()
        }
    }
}

