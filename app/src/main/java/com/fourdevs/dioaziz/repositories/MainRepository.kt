package com.fourdevs.dioaziz.repositories

import android.content.Context
import com.fourdevs.dioaziz.room.ApplicantDao
import com.fourdevs.dioaziz.ui.core.GeneratePDF
import com.fourdevs.dioaziz.ui.data.PassportData
import com.fourdevs.dioaziz.utils.CustomDate
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val generatePDF: GeneratePDF,
    private val customDate: CustomDate,
    private val applicantDao: ApplicantDao,

    ) {
    fun savePassportData(
        passportData : PassportData,
        newPassportData: (PassportData?) -> Unit
    ) {
        generatePDF.editAndGeneratePDF(passportData, newPassportData)
    }

    fun changeDateFormat(
        timestamp: Long,
        banglaDate: (String) -> Unit
    ) {
        banglaDate(customDate.main(timestamp))
    }

    suspend fun insert(passportData: PassportData) {
        withContext(Dispatchers.IO) {
            applicantDao.insertAll(passportData)
        }
    }

    suspend fun getPassportData(enrollId: String): PassportData? {
        return withContext(Dispatchers.IO) {
            applicantDao.getPassportData(enrollId)
        }
    }

    suspend fun getAllPassportData(): List<PassportData> {
        return withContext(Dispatchers.IO) {
            applicantDao.getAll()
        }
    }
}