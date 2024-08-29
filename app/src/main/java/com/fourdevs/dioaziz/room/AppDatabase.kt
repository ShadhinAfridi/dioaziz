package com.fourdevs.dioaziz.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fourdevs.dioaziz.ui.data.PassportData
import com.fourdevs.dioaziz.utils.Constants

@Database(entities = [PassportData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun applicantDao(): ApplicantDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java, Constants.KEY_DB
                        ).build()
                    }
                }
            }
            return INSTANCE
        }
    }
}