package com.fourdevs.dioaziz.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.text.input.KeyboardType
import com.fourdevs.dioaziz.utils.Constants
import com.fourdevs.dioaziz.viewmodels.MainViewModel
import kotlinx.coroutines.launch

@Composable
fun ApplicationFields(
    viewModel: MainViewModel,
    localFocusManager: FocusManager
) {
    val pvrNo by viewModel.pvrNo.collectAsState()
    val date by viewModel.date.collectAsState()
    val endDate by viewModel.endDate.collectAsState()
    val enrollId by viewModel.enrollId.collectAsState()
    val isClicked by viewModel.isApplicationClicked.collectAsState()
    val isError by viewModel.isApplicationError.collectAsState()

    Divider(
        title = Constants.KEY_TITLE_APPLICATION_INFO_BN,
        onClick = { clicked ->
            // Handle the click event here
            viewModel.updateApplicationClicked(clicked)

            if (clicked) {
                viewModel.clickedDropdownState(Constants.KEY_APPLICATION)
            }
        },
        isClicked = isClicked,
        isError = isError
    )

    ColumnDropDown(
        isClicked = isClicked,
    ) {
        if (isClicked) {
            CustomInputField(
                text = Constants.KEY_PVR_NO_BN,
                value = pvrNo,
                onChange = { viewModel.updatePvrNo(it) },
                localFocusManager = localFocusManager,
            )
            CustomInputField(
                text = Constants.KEY_DATE_BN,
                value = date,
                onChange = {
                    viewModel.updateDate(it)
                },
                localFocusManager = localFocusManager,
                trailingIcon = {
                    IconButton(onClick = {
                        viewModel.updateOpenDialog(true)
                        viewModel.updatePickedDateFieldName(Constants.KEY_DATE_BN)
                    }) {
                        Icon(imageVector = Icons.Filled.DateRange, contentDescription = "Date")
                    }
                }
            )
            CustomInputField(
                text = Constants.KEY_END_DATE_BN,
                value = endDate,
                onChange = { viewModel.updateEndDate(it) },
                localFocusManager = localFocusManager,
                trailingIcon = {
                    IconButton(onClick = {
                        viewModel.updateOpenDialog(true)
                        viewModel.updatePickedDateFieldName(Constants.KEY_END_DATE_BN)
                    }) {
                        Icon(imageVector = Icons.Filled.DateRange, contentDescription = "Date")
                    }
                }
            )
            CustomInputField(
                text = Constants.KEY_ENROLL_ID_BN,
                value = enrollId,
                onChange = { viewModel.updateEnrollId(it) },
                localFocusManager = localFocusManager,
            )
        }
    }
}

@Composable
fun PersonalFields(
    viewModel: MainViewModel,
    localFocusManager: FocusManager
) {
    val applicantName by viewModel.applicantName.collectAsState("")
    val nidBrcNo by viewModel.nidBrcNo.collectAsState("")
    val applicantMobileNo by viewModel.applicantMobileNo.collectAsState("")
    val dob by viewModel.dob.collectAsState("")
    val occupation by viewModel.occupation.collectAsState("")
    val father by viewModel.father.collectAsState("")
    val mother by viewModel.mother.collectAsState("")
    val isClicked by viewModel.isPersonalClicked.collectAsState()
    val isError by viewModel.isPersonalError.collectAsState()

    Divider(
        title = Constants.KEY_TITLE_PERSONAL_INFO_BN,
        onClick = { clicked ->
            // Handle the click event here
            viewModel.updatePersonalClicked(clicked)
            if (clicked) {
                viewModel.clickedDropdownState(Constants.KEY_PERSONAL)
            }
        },
        isClicked = isClicked,
        isError = isError
    )
    ColumnDropDown(
        isClicked = isClicked,
    ) {
        if (isClicked) {
            CustomInputField(
                text = Constants.KEY_APPLICANT_NAME_BN,
                value = applicantName,
                onChange = { viewModel.updateApplicantName(it) },
                localFocusManager = localFocusManager,
            )

            CustomInputField(
                text = Constants.KEY_NID_BIRTH_BN,
                value = nidBrcNo,
                onChange = { viewModel.updateNidBrcNo(it) },
                localFocusManager = localFocusManager,
                keyboardType = KeyboardType.Number
            )
            CustomInputField(
                text = Constants.KEY_FATHER_BN,
                value = father,
                onChange = { viewModel.updateFather(it) },
                localFocusManager = localFocusManager,
            )
            CustomInputField(
                text = Constants.KEY_MOTHER_BN,
                value = mother,
                onChange = { viewModel.updateMother(it) },
                localFocusManager = localFocusManager,
            )
            CustomInputField(
                text = Constants.KEY_DATE_OF_BIRTH_BN,
                value = dob,
                onChange = { viewModel.updateDob(it) },
                localFocusManager = localFocusManager,
                trailingIcon = {
                    IconButton(onClick = {
                        viewModel.updateOpenDialog(true)
                        viewModel.updatePickedDateFieldName(Constants.KEY_DATE_OF_BIRTH_BN)
                    }) {
                        Icon(imageVector = Icons.Filled.DateRange, contentDescription = "Date")
                    }
                }
            )
            CustomInputField(
                text = Constants.KEY_OCCUPATION_BN,
                value = occupation,
                onChange = { viewModel.updateOccupation(it) },
                localFocusManager = localFocusManager,
            )
            CustomInputField(
                text = Constants.KEY_MOBILE_NO_BN,
                value = applicantMobileNo,
                onChange = { viewModel.updateApplicantMobileNo(it) },
                localFocusManager = localFocusManager,
                keyboardType = KeyboardType.Phone
            )
        }
    }
}

@Composable
fun PermanentAddressFields(
    viewModel: MainViewModel,
    localFocusManager: FocusManager
) {
    val permanentAddress by viewModel.permanentAddress.collectAsState("")
    val permanentPost by viewModel.permanentPost.collectAsState("")
    val permanentThana by viewModel.permanentThana.collectAsState("")
    val permanentZilla by viewModel.permanentZilla.collectAsState("")
    val isClicked by viewModel.isPermanentAddressClicked.collectAsState()
    val isError by viewModel.isPermanentAddressError.collectAsState()
    val zillaList by viewModel.zillaList.collectAsState()
    val thanaList by viewModel.thanaList.collectAsState()
    val postOfficeList by viewModel.postList.collectAsState()


    Divider(
        title = Constants.KEY_TITLE_PERMANENT_INFO_BN,
        onClick = { clicked ->
            // Handle the click event here
            viewModel.updatePermanentAddressClicked(clicked)
            if (clicked) {
                viewModel.clickedDropdownState(Constants.KEY_PERMANENT_ADDRESS)
            }
        },
        isClicked = isClicked,
        isError = isError
    )
    ColumnDropDown(
        isClicked = isClicked,

        ) {
        if (isClicked) {
            CustomInputField(
                text = Constants.KEY_ZILLA_BN,
                value = permanentZilla,
                onChange = {
                    viewModel.updatePermanentZilla(it)
                    viewModel.updateZillaList(it)
                },
                localFocusManager = localFocusManager,
                supportingText = {
                    CustomDropDownItem(zillaList) {
                        viewModel.updatePermanentZilla(it)
                        viewModel.updateZillaList("")
                    }
                }
            )
            CustomInputField(
                text = Constants.KEY_THANA_BN,
                value = permanentThana,
                onChange = {
                    viewModel.updatePermanentThana(it)
                    viewModel.updateThanaList(it, permanentZilla)
                },
                localFocusManager = localFocusManager,
                supportingText = {
                    CustomDropDownItem(thanaList) {
                        viewModel.updatePermanentThana(it)
                        viewModel.updateThanaList("", "")
                    }
                }
            )
            CustomInputField(
                text = Constants.KEY_POST_BN,
                value = permanentPost,
                onChange = {
                    viewModel.updatePermanentPost(it)
                    viewModel.updatePostList(it, thana = permanentThana, zilla = permanentZilla)
                },
                localFocusManager = localFocusManager,
                supportingText = {
                    CustomDropDownItem(postOfficeList) {
                        viewModel.updatePermanentPost(it)
                        viewModel.updatePostList("", "", "")
                    }
                }
            )
            CustomInputField(
                text = Constants.KEY_PERMANENT_ADDRESS_BN,
                value = permanentAddress,
                onChange = { viewModel.updatePermanentAddress(it) },
                localFocusManager = localFocusManager,
            )

        }
    }
}

@Composable
fun PresentAddressFields(
    viewModel: MainViewModel,
    localFocusManager: FocusManager
) {
    val presentAddress by viewModel.presentAddress.collectAsState("")
    val presentPost by viewModel.presentPost.collectAsState("")
    val presentThana by viewModel.presentThana.collectAsState("")
    val presentZilla by viewModel.presentZilla.collectAsState("")
    val addressCheckedState by viewModel.addressCheckedState.collectAsState()
    val isClicked by viewModel.isPresentAddressClicked.collectAsState()
    val isError by viewModel.isPresentAddressError.collectAsState()

    val postOfficeList by viewModel.postList.collectAsState()
    val zillaList by viewModel.zillaList.collectAsState()
    val thanaList by viewModel.thanaList.collectAsState()


    Divider(
        title = Constants.KEY_TITLE_PRESENT_INFO_BN,
        onClick = { clicked ->
            // Handle the click event here
            viewModel.updatePresentAddressClicked(clicked)
            if (clicked) {
                viewModel.clickedDropdownState(Constants.KEY_PRESENT_ADDRESS)
            }
        },
        isClicked = isClicked,
        isError = isError
    )
    ColumnDropDown(
        isClicked = isClicked,

        ) {
        if (isClicked) {
            CustomCheckbox(
                checkedState = addressCheckedState,
                text = Constants.KEY_SAME_ADDRESS_BN
            ) {
                viewModel.updateAddressCheckedState(it)
            }

            CustomInputField(
                text = Constants.KEY_ZILLA_BN,
                value = presentZilla,
                onChange = {
                    viewModel.updatePresentZilla(it)
                    viewModel.updateZillaList(it)
                },
                localFocusManager = localFocusManager,
                supportingText = {
                    CustomDropDownItem(zillaList) {
                        viewModel.updatePresentZilla(it)
                        viewModel.updateZillaList("")
                    }
                }
            )
            CustomInputField(
                text = Constants.KEY_THANA_BN,
                value = presentThana,
                onChange = {
                    viewModel.updatePresentThana(it)
                    viewModel.updateThanaList(it, presentZilla)
                },
                localFocusManager = localFocusManager,
                supportingText = {
                    CustomDropDownItem(thanaList) {
                        viewModel.updatePresentThana(it)
                        viewModel.updateThanaList("", presentZilla)
                    }
                }
            )
            CustomInputField(
                text = Constants.KEY_POST_BN,
                value = presentPost,
                onChange = {
                    viewModel.updatePresentPost(it)
                    viewModel.updatePostList(it, thana = presentThana, zilla = presentZilla)
                },
                localFocusManager = localFocusManager,
                supportingText = {
                    CustomDropDownItem(postOfficeList) {
                        viewModel.updatePresentPost(it)
                        viewModel.updatePostList("", "", "")
                    }
                }
            )
            CustomInputField(
                text = Constants.KEY_PRESENT_ADDRESS_BN,
                value = presentAddress,
                onChange = { viewModel.updatePresentAddress(it) },
                localFocusManager = localFocusManager,
            )


        }
    }
}

@Composable
fun PersonOneFields(
    viewModel: MainViewModel,
    localFocusManager: FocusManager
) {
    val personOneName by viewModel.personOneName.collectAsState("")
    val personOneRelation by viewModel.personOneRelation.collectAsState("")
    val personOneMobileNo by viewModel.personOneMobileNo.collectAsState("")
    val fatherCheckedState by viewModel.fatherCheckedState.collectAsState(true)
    val isClicked by viewModel.isPersonOneClicked.collectAsState()
    val isError by viewModel.isPersonOneError.collectAsState()


    Divider(
        title = Constants.KEY_TITLE_IDENTIFY_ONE_INFO_BN,
        onClick = { clicked ->
            // Handle the click event here
            viewModel.updatePersonOneClicked(clicked)
            if (clicked) {
                viewModel.clickedDropdownState(Constants.KEY_PERSON_ONE)
            }
        },
        isClicked = isClicked,
        isError = isError
    )
    ColumnDropDown(
        isClicked = isClicked,

        ) {
        if (isClicked) {
            CustomCheckbox(
                checkedState = fatherCheckedState,
                text = Constants.KEY_FATHER_BN
            ) {
                viewModel.updateFatherCheckedState(it)

            }
            CustomInputField(
                text = Constants.KEY_NAME_BN,
                value = personOneName,
                onChange = { viewModel.updatePersonOneName(it) },
                localFocusManager = localFocusManager,
            )
            CustomInputField(
                text = Constants.KEY_RELATION_BN,
                value = personOneRelation,
                onChange = { viewModel.updatePersonOneRelation(it) },
                localFocusManager = localFocusManager,
            )
            CustomInputField(
                text = Constants.KEY_MOBILE_NO_BN,
                value = personOneMobileNo,
                onChange = { viewModel.updatePersonOneMobileNo(it) },
                localFocusManager = localFocusManager,
                keyboardType = KeyboardType.Phone
            )
        }
    }
}

@Composable
fun PersonTwoFields(
    viewModel: MainViewModel,
    localFocusManager: FocusManager
) {
    val personTwoName by viewModel.personTwoName.collectAsState("")
    val personTwoRelation by viewModel.personTwoRelation.collectAsState("")
    val personTwoMobileNo by viewModel.personTwoMobileNo.collectAsState("")
    val motherCheckedState by viewModel.motherCheckedState.collectAsState(true)
    val isClicked by viewModel.isPersonTwoClicked.collectAsState()
    val isError by viewModel.isPersonTwoError.collectAsState()


    Divider(
        title = Constants.KEY_TITLE_IDENTIFY_TWO_INFO_BN,
        onClick = { clicked ->
            // Handle the click event here
            viewModel.updatePersonTwoClicked(clicked)
            if (clicked) {
                viewModel.clickedDropdownState(Constants.KEY_PERSON_TWO)
            }
        },
        isClicked = isClicked,
        isError = isError
    )
    ColumnDropDown(
        isClicked = isClicked,

        ) {
        if (isClicked) {
            CustomCheckbox(
                checkedState = motherCheckedState,
                text = Constants.KEY_MOTHER_BN
            ) {
                viewModel.updateMotherCheckedState(it)
            }
            CustomInputField(
                text = Constants.KEY_NAME_BN,
                value = personTwoName,
                onChange = { viewModel.updatePersonTwoName(it) },
                localFocusManager = localFocusManager,
            )
            CustomInputField(
                text = Constants.KEY_RELATION_BN,
                value = personTwoRelation,
                onChange = { viewModel.updatePersonTwoRelation(it) },
                localFocusManager = localFocusManager,
            )
            CustomInputField(
                text = Constants.KEY_MOBILE_NO_BN,
                value = personTwoMobileNo,
                onChange = { viewModel.updatePersonTwoMobileNo(it) },
                localFocusManager = localFocusManager,
                keyboardType = KeyboardType.Phone
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OpenDialogDiFields(
    viewModel: MainViewModel,
) {
    val snackState = remember { SnackbarHostState() }
    val snackScope = rememberCoroutineScope()
    val datePickerState = rememberDatePickerState()
    val confirmEnabled = remember {
        derivedStateOf { datePickerState.selectedDateMillis != null }
    }
    val pickedDateFieldName by viewModel.pickedDateFieldName.collectAsState()
    val selectedDate by viewModel.pickedDate.collectAsState()

    CustomDatePicker(
        openDialog = true,
        onDismissRequest = { viewModel.updateOpenDialog(false) },
        datePickerState = datePickerState,
        confirmEnabled = confirmEnabled.value,
        onConfirmClick = {
            viewModel.updateOpenDialog(false)
            snackScope.launch {
                snackState.showSnackbar(
                    "Selected date timestamp: ${datePickerState.selectedDateMillis}"
                )
            }
        },
        onCancelClick = { viewModel.updateOpenDialog(false) },
        pickedDate = {
            viewModel.changeDateFormat(it)
            when (pickedDateFieldName) {
                Constants.KEY_DATE_BN -> viewModel.updateDate(selectedDate)
                Constants.KEY_END_DATE_BN -> viewModel.updateEndDate(selectedDate)
                Constants.KEY_DATE_OF_BIRTH_BN -> viewModel.updateDob(selectedDate)
            }
        }
    )
    SnackbarHost(hostState = snackState, Modifier)
}