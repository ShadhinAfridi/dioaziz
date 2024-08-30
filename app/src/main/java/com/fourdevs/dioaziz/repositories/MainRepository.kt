package com.fourdevs.dioaziz.repositories

import android.graphics.Bitmap
import android.os.Build
import androidx.annotation.RequiresApi
import com.fourdevs.dioaziz.room.ApplicantDao
import com.fourdevs.dioaziz.ui.core.GeneratePDF
import com.fourdevs.dioaziz.ui.data.PassportData
import com.fourdevs.dioaziz.utils.CustomDate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val generatePDF: GeneratePDF,
    private val customDate: CustomDate,
    private val applicantDao: ApplicantDao,
) {
    fun savePassportData(
        passportData: PassportData,
        imageBitmap: (Bitmap?) -> Unit,
        newPassportData: (PassportData?) -> Unit
    ) {
        generatePDF.editAndGeneratePDF(passportData, newPassportData, imageBitmap)
    }

    fun changeDateFormat(
        timestamp: Long,
        banglaDate: (String) -> Unit
    ) {
        banglaDate(customDate.main(timestamp))
    }

    fun convertIfNeeded(value: String): String {
        return if (containsEnglishDigits(value)) {
            convertEnglishToBanglaDigits(value)
        } else {
            value
        }
    }

    private fun containsEnglishDigits(input: String): Boolean {
        val regex = Regex("[0-9]")
        return regex.containsMatchIn(input)
    }

    private fun convertEnglishToBanglaDigits(englishNumber: String): String {
        return customDate.convertEnglishToBanglaDigits(englishNumber)
    }

    fun openPdfFile(filePath: String) {
        val file = File(filePath)
        generatePDF.openPdfFile(file)
    }

    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    fun sharePdfFile(filePath: String) {
        val file = File(filePath)
        generatePDF.sendFile(file)
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