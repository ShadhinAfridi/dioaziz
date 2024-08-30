package com.fourdevs.dioaziz.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CustomDate @Inject constructor() {
    fun convertEnglishToBanglaDigits(englishNumber: String): String {
        val banglaDigits = mapOf(
            '0' to '০',
            '1' to '১',
            '2' to '২',
            '3' to '৩',
            '4' to '৪',
            '5' to '৫',
            '6' to '৬',
            '7' to '৭',
            '8' to '৮',
            '9' to '৯'
        )
        return englishNumber.map { banglaDigits[it] ?: it }.joinToString("")
    }

    fun convertTimestampToDate(timestamp: Long): String {
        val date = Date(timestamp)
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        return dateFormat.format(date)
    }

    private fun convertTimestampToBanglaDate(timestamp: Long): String {
        val formattedDate = convertTimestampToDate(timestamp)
        return convertEnglishToBanglaDigits(formattedDate)
    }

    fun main(timestamp : Long) : String {
        return convertTimestampToBanglaDate(timestamp)
    }
}