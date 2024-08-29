package com.fourdevs.dioaziz.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.fourdevs.dioaziz.ui.data.PassportData

@Dao
interface ApplicantDao {
    @Query("SELECT * FROM passport_data")
    fun getAll(): List<PassportData>

    @Insert
    fun insertAll(vararg passportData: PassportData)

    @Query("SELECT * FROM passport_data WHERE enroll_id = :enrollId")
    suspend fun getPassportData(enrollId: String): PassportData?

    @Delete
    fun delete(passportData: PassportData)
}