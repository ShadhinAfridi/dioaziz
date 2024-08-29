package com.fourdevs.dioaziz.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fourdevs.dioaziz.repositories.MainRepository
import com.fourdevs.dioaziz.ui.data.PassportData
import com.fourdevs.dioaziz.ui.data.addresses
import com.fourdevs.dioaziz.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _pvrNo = MutableStateFlow("")
    val pvrNo: StateFlow<String> = _pvrNo

    private val _date = MutableStateFlow("")
    val date: StateFlow<String> = _date

    private val _endDate = MutableStateFlow("")
    val endDate: StateFlow<String> = _endDate

    private val _applicantName = MutableStateFlow("")
    val applicantName: StateFlow<String> = _applicantName

    private val _enrollId = MutableStateFlow("")
    val enrollId: StateFlow<String> = _enrollId

    private val _nidBrcNo = MutableStateFlow("")
    val nidBrcNo: StateFlow<String> = _nidBrcNo

    private val _father = MutableStateFlow("")
    val father: StateFlow<String> = _father

    private val _mother = MutableStateFlow("")
    val mother: StateFlow<String> = _mother

    private val _dob = MutableStateFlow("")
    val dob: StateFlow<String> = _dob

    private val _occupation = MutableStateFlow("")
    val occupation: StateFlow<String> = _occupation

    private val _permanentAddress = MutableStateFlow("")
    val permanentAddress: StateFlow<String> = _permanentAddress

    private val _permanentPost = MutableStateFlow("")
    val permanentPost: StateFlow<String> = _permanentPost

    private val _permanentThana = MutableStateFlow("")
    val permanentThana: StateFlow<String> = _permanentThana

    private val _permanentZilla = MutableStateFlow("")
    val permanentZilla: StateFlow<String> = _permanentZilla

    private val _presentAddress = MutableStateFlow("")
    val presentAddress: StateFlow<String> = _presentAddress

    private val _presentPost = MutableStateFlow("")
    val presentPost: StateFlow<String> = _presentPost

    private val _presentThana = MutableStateFlow("")
    val presentThana: StateFlow<String> = _presentThana

    private val _presentZilla = MutableStateFlow("")
    val presentZilla: StateFlow<String> = _presentZilla

    private val _applicantMobileNo = MutableStateFlow("")
    val applicantMobileNo: StateFlow<String> = _applicantMobileNo

    private val _personOneName = MutableStateFlow("")
    val personOneName: StateFlow<String> = _personOneName

    private val _personOneRelation = MutableStateFlow("")
    val personOneRelation: StateFlow<String> = _personOneRelation

    private val _personOneMobileNo = MutableStateFlow("")
    val personOneMobileNo: StateFlow<String> = _personOneMobileNo

    private val _personTwoName = MutableStateFlow("")
    val personTwoName: StateFlow<String> = _personTwoName

    private val _personTwoRelation = MutableStateFlow("")
    val personTwoRelation: StateFlow<String> = _personTwoRelation

    private val _personTwoMobileNo = MutableStateFlow("")
    val personTwoMobileNo: StateFlow<String> = _personTwoMobileNo

    private val _pickedDate = MutableStateFlow("")
    val pickedDate: StateFlow<String> = _pickedDate

    private val _pickedDateFieldName = MutableStateFlow("")
    val pickedDateFieldName: StateFlow<String> = _pickedDateFieldName

    private val _zillaList = MutableStateFlow<List<String>>(emptyList())
    val zillaList: StateFlow<List<String>> = _zillaList

    private val _thanaList = MutableStateFlow<List<String>>(emptyList())
    val thanaList: StateFlow<List<String>> = _thanaList

    private val _postList = MutableStateFlow<List<String>>(emptyList())
    val postList: StateFlow<List<String>> = _postList

    private val _isApplicationClicked = MutableStateFlow(true)
    val isApplicationClicked: StateFlow<Boolean> = _isApplicationClicked

    private val _isPersonalClicked = MutableStateFlow(false)
    val isPersonalClicked: StateFlow<Boolean> = _isPersonalClicked

    private val _isPermanentAddressClicked = MutableStateFlow(false)
    val isPermanentAddressClicked: StateFlow<Boolean> = _isPermanentAddressClicked

    private val _isPresentAddressClicked = MutableStateFlow(false)
    val isPresentAddressClicked: StateFlow<Boolean> = _isPresentAddressClicked

    private val _isPersonOneClicked = MutableStateFlow(false)
    val isPersonOneClicked: StateFlow<Boolean> = _isPersonOneClicked

    private val _isPersonTwoClicked = MutableStateFlow(false)
    val isPersonTwoClicked: StateFlow<Boolean> = _isPersonTwoClicked

    private val _addressCheckedState = MutableStateFlow(true)
    val addressCheckedState: StateFlow<Boolean> = _addressCheckedState

    private val _fatherCheckedState = MutableStateFlow(true)
    val fatherCheckedState: StateFlow<Boolean> = _fatherCheckedState

    private val _motherCheckedState = MutableStateFlow(true)
    val motherCheckedState: StateFlow<Boolean> = _motherCheckedState

    private val _isError = MutableStateFlow(false)
    val isError: StateFlow<Boolean> = _isError

    private val _openDialog = MutableStateFlow(false)
    val openDialog: StateFlow<Boolean> = _openDialog

    private val _isApplicationError = MutableStateFlow(false)
    val isApplicationError: StateFlow<Boolean> = _isApplicationError

    private val _isPersonalError = MutableStateFlow(false)
    val isPersonalError: StateFlow<Boolean> = _isPersonalError

    private val _isPermanentAddressError = MutableStateFlow(false)
    val isPermanentAddressError: StateFlow<Boolean> = _isPermanentAddressError

    private val _isPresentAddressError = MutableStateFlow(false)
    val isPresentAddressError: StateFlow<Boolean> = _isPresentAddressError

    private val _isPersonOneError = MutableStateFlow(false)
    val isPersonOneError: StateFlow<Boolean> = _isPersonOneError

    private val _isPersonTwoError = MutableStateFlow(false)
    val isPersonTwoError: StateFlow<Boolean> = _isPersonTwoError


    // Update functions
    fun updatePvrNo(value: String) {
        _pvrNo.value = value
    }

    fun updateDate(value: String) {
        _date.value = value
    }

    fun updateEndDate(value: String) {
        _endDate.value = value
    }

    fun updateApplicantName(value: String) {
        _applicantName.value = value
    }

    fun updateEnrollId(value: String) {
        _enrollId.value = value
    }

    fun updateNidBrcNo(value: String) {
        _nidBrcNo.value = value
    }

    fun updateFather(value: String) {
        _father.value = value
    }

    fun updateMother(value: String) {
        _mother.value = value
    }

    fun updateDob(value: String) {
        _dob.value = value
    }

    fun updateOccupation(value: String) {
        _occupation.value = value
    }

    fun updatePermanentAddress(value: String) {
        _permanentAddress.value = value
    }

    fun updatePermanentPost(value: String) {
        _permanentPost.value = value
    }

    fun updatePermanentThana(value: String) {
        _permanentThana.value = value
    }

    fun updatePermanentZilla(value: String) {
        _permanentZilla.value = value
    }

    fun updatePresentAddress(value: String) {
        _presentAddress.value = value
    }

    fun updatePresentPost(value: String) {
        _presentPost.value = value
    }

    fun updatePresentThana(value: String) {
        _presentThana.value = value
    }

    fun updatePresentZilla(value: String) {
        _presentZilla.value = value
    }

    fun updateApplicantMobileNo(value: String) {
        _applicantMobileNo.value = value
    }

    fun updatePersonOneName(value: String) {
        _personOneName.value = value
    }

    fun updatePersonOneRelation(value: String) {
        _personOneRelation.value = value
    }

    fun updatePersonOneMobileNo(value: String) {
        _personOneMobileNo.value = value
    }

    fun updatePersonTwoName(value: String) {
        _personTwoName.value = value
    }

    fun updatePersonTwoRelation(value: String) {
        _personTwoRelation.value = value
    }

    fun updatePersonTwoMobileNo(value: String) {
        _personTwoMobileNo.value = value
    }

    private fun updatePickedDate(value: String) {
        _pickedDate.value = value
    }

    fun updateApplicationClicked(value: Boolean) {
        _isApplicationClicked.value = value
    }

    fun updateOpenDialog(value: Boolean) {
        _openDialog.value = value
    }

    fun updatePersonalClicked(value: Boolean) {
        _isPersonalClicked.value = value
    }

    fun updatePermanentAddressClicked(value: Boolean) {
        _isPermanentAddressClicked.value = value
    }

    fun updatePresentAddressClicked(value: Boolean) {
        _isPresentAddressClicked.value = value
    }

    fun updatePersonOneClicked(value: Boolean) {
        _isPersonOneClicked.value = value
    }

    fun updatePersonTwoClicked(value: Boolean) {
        _isPersonTwoClicked.value = value
    }

    fun updateAddressCheckedState(isChecked: Boolean) {
        _addressCheckedState.value = isChecked
    }

    fun updateFatherCheckedState(isChecked: Boolean) {
        _fatherCheckedState.value = isChecked
    }

    fun updateMotherCheckedState(isChecked: Boolean) {
        _motherCheckedState.value = isChecked
    }

    fun updatePickedDateFieldName(value: String) {
        _pickedDateFieldName.value = value
    }

    private fun updateApplicationError(value: Boolean) {
        _isApplicationError.value = value
    }

    private fun updatePersonalError(value: Boolean) {
        _isPersonalError.value = value
    }

    private fun updatePresentAddressError(value: Boolean) {
        _isPresentAddressError.value = value
    }

    private fun updatePermanentAddressError(value: Boolean) {
        _isPermanentAddressError.value = value
    }

    private fun updatePersonOneError(value: Boolean) {
        _isPersonOneError.value = value
    }

    private fun updatePersonTwoError(value: Boolean) {
        _isPersonTwoError.value = value
    }

    fun updateError(value: Boolean) {
        _isError.value = value
    }

    fun updateZillaList(value: String) {
        if (value.isNotEmpty()) {
            _zillaList.value = addresses
                .filter { address ->
                    address.zilla.contains(value, ignoreCase = true)
                }
                .map { address -> address.zilla }
                .distinct()
        } else {
            _zillaList.value = emptyList()
        }
    }

    fun updateThanaList(value: String, zilla: String) {
        if (value.isNotEmpty()) {
            _thanaList.value = addresses
                .filter { address ->
                    address.zilla.equals(zilla, ignoreCase = true) &&  // Match zilla name
                            address.thana.contains(value, ignoreCase = true)  // Match thana name
                }
                .map { address -> address.thana }
                .distinct()
        } else {
            _thanaList.value = emptyList()
        }
    }

    fun updatePostList(value: String, thana: String, zilla: String) {
        if (value.isNotEmpty()) {
            _postList.value = addresses
                .filter { address ->
                    address.zilla.equals(zilla, ignoreCase = true) &&  // Match zilla name
                            address.thana.equals(thana, ignoreCase = true) &&  // Match thana name
                            address.postOffice.contains(value, ignoreCase = true)
                }
                .map { address -> address.postOffice }
                .distinct()
        } else {
            _postList.value = emptyList()
        }
    }

    fun clickedDropdownState(clickedDropdown: String) {
        val dropdownMap = mapOf(
            "Application" to ::updateApplicationClicked,
            "Personal" to ::updatePersonalClicked,
            "PermanentAddress" to ::updatePermanentAddressClicked,
            "PresentAddress" to ::updatePresentAddressClicked,
            "PersonOne" to ::updatePersonOneClicked,
            "PersonTwo" to ::updatePersonTwoClicked
        )

        dropdownMap.forEach { (key, updateFunction) ->
            updateFunction(key == clickedDropdown)
        }
    }


    private fun validateApplicationData(): Boolean {
        return pvrNo.value.isEmpty() ||
                date.value.isEmpty() ||
                endDate.value.isEmpty() ||
                enrollId.value.isEmpty()
    }

    private fun validatePersonalData(): Boolean {
        return applicantName.value.isEmpty() ||
                nidBrcNo.value.isEmpty() ||
                father.value.isEmpty() ||
                mother.value.isEmpty() ||
                dob.value.isEmpty() ||
                occupation.value.isEmpty() ||
                applicantMobileNo.value.isEmpty()
    }

    private fun validatePermanentAddressData(): Boolean {
        return permanentAddress.value.isEmpty() ||
                permanentPost.value.isEmpty() ||
                permanentThana.value.isEmpty() ||
                permanentZilla.value.isEmpty()
    }

    private fun validatePresentAddressData(): Boolean {
        return presentAddress.value.isEmpty() ||
                presentPost.value.isEmpty() ||
                presentThana.value.isEmpty() ||
                presentZilla.value.isEmpty()
    }

    private fun validatePersonOne(): Boolean {
        return personOneName.value.isEmpty() ||
                personOneRelation.value.isEmpty() ||
                personOneMobileNo.value.isEmpty()
    }

    private fun validatePersonTwoData(): Boolean {
        return personTwoName.value.isEmpty() ||
                personTwoRelation.value.isEmpty() ||
                personTwoMobileNo.value.isEmpty()
    }

    private fun validatePassportData(passportData: PassportData): Boolean {
        return passportData.pvrNo.isNotEmpty() &&
                passportData.date.isNotEmpty() &&
                passportData.endDate.isNotEmpty() &&
                passportData.applicantName.isNotEmpty() &&
                passportData.enrollId.isNotEmpty() &&
                passportData.nidBrcNo.isNotEmpty() &&
                passportData.father.isNotEmpty() &&
                passportData.mother.isNotEmpty() &&
                passportData.dob.isNotEmpty() &&
                passportData.occupation.isNotEmpty() &&
                passportData.permanentAddress.isNotEmpty() &&
                passportData.permanentPost.isNotEmpty() &&
                passportData.permanentThana.isNotEmpty() &&
                passportData.permanentZilla.isNotEmpty() &&
                passportData.presentAddress.isNotEmpty() &&
                passportData.presentPost.isNotEmpty() &&
                passportData.presentThana.isNotEmpty() &&
                passportData.presentZilla.isNotEmpty() &&
                passportData.applicantMobileNo.isNotEmpty() &&
                passportData.personOneName.isNotEmpty() &&
                passportData.personOneRelation.isNotEmpty() &&
                passportData.personOneMobileNo.isNotEmpty() &&
                passportData.personTwoName.isNotEmpty() &&
                passportData.personTwoRelation.isNotEmpty() &&
                passportData.personTwoMobileNo.isNotEmpty()
    }

    private fun validateAllFields(): Boolean {
        val validations = listOf(
            Pair(::validateApplicationData, ::updateApplicationError),
            Pair(::validatePersonalData, ::updatePersonalError),
            Pair(::validatePermanentAddressData, ::updatePermanentAddressError),
            Pair(::validatePresentAddressData, ::updatePresentAddressError),
            Pair(::validatePersonOne, ::updatePersonOneError),
            Pair(::validatePersonTwoData, ::updatePersonTwoError)
        )

        for ((validation, errorUpdate) in validations) {
            if (validation()) {
                errorUpdate(true)
                updateError(true)
                return false
            } else {
                errorUpdate(false)
            }
        }
        return true
    }

    fun savePassportData() {
        if (!validateAllFields()) {
            return
        }

        val passportData = PassportData(
            pvrNo = pvrNo.value,
            date = date.value,
            endDate = endDate.value,
            applicantName = applicantName.value,
            enrollId = enrollId.value,
            nidBrcNo = nidBrcNo.value,
            father = father.value,
            mother = mother.value,
            dob = dob.value,
            occupation = occupation.value,
            permanentAddress = permanentAddress.value,
            permanentPost = permanentPost.value,
            permanentThana = permanentThana.value,
            permanentZilla = permanentZilla.value,
            presentAddress = presentAddress.value,
            presentPost = presentPost.value,
            presentThana = presentThana.value,
            presentZilla = presentZilla.value,
            applicantMobileNo = applicantMobileNo.value,
            personOneName = personOneName.value,
            personOneRelation = personOneRelation.value,
            personOneMobileNo = personOneMobileNo.value,
            personTwoName = personTwoName.value,
            personTwoRelation = personTwoRelation.value,
            personTwoMobileNo = personTwoMobileNo.value
        )

        viewModelScope.launch {
            try {
                if (validatePassportData(passportData)) {
                    repository.savePassportData(passportData) {
                        it?.let {
                            insert(passportData)
                        }
                    }
                } else {
                    updateError(true)
                }
            } catch (e: Exception) {
                updateError(true)
            }
        }
    }


    fun changeDateFormat(timestamp: Long) {
        repository.changeDateFormat(timestamp) {
            updatePickedDate(it)
        }
    }

    private fun currentDate() {
        repository.changeDateFormat(System.currentTimeMillis()) {
            updateDate(it)
        }
    }

    private fun clearPresentAddressFields() {
        updatePresentAddress("")
        updatePresentPost("")
        updatePresentThana("")
        updatePresentZilla("")
    }

    private fun clearPersonOneFields() {
        updatePersonOneName("")
        updatePersonOneRelation("")
    }

    private fun clearPersonTwoFields() {
        updatePersonTwoName("")
        updatePersonTwoRelation("")
    }

    private fun insert(passportData: PassportData) {
        viewModelScope.launch {
            repository.insert(passportData)
        }
    }

    fun getPassportData(enrollId: String) {
        viewModelScope.launch {
            val data = repository.getPassportData(enrollId)
            // Handle the retrieved data
        }
    }

    fun getAllPassportData() {
        viewModelScope.launch {
            val allData = repository.getAllPassportData()
            // Handle the list of data
        }
    }

    fun updateCheckData() {
        if (addressCheckedState.value) {
            updatePresentAddress(permanentAddress.value)
            updatePresentPost(permanentPost.value)
            updatePresentThana(permanentThana.value)
            updatePresentZilla(permanentZilla.value)
        } else {
            clearPresentAddressFields()
        }
        if (fatherCheckedState.value) {
            updatePersonOneName(father.value)
            updatePersonOneRelation(Constants.KEY_FATHER_BN)
        } else {
            clearPersonOneFields()
        }
        if (motherCheckedState.value) {
            updatePersonTwoName(mother.value)
            updatePersonTwoRelation(Constants.KEY_MOTHER_BN)
        } else {
            clearPersonTwoFields()
        }
    }

    init {
        currentDate()
    }

}

