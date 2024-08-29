package com.fourdevs.dioaziz.hilt

import android.app.Application
import android.content.Context
import com.fourdevs.dioaziz.room.AppDatabase
import com.fourdevs.dioaziz.room.ApplicantDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return AppDatabase.getDatabase(context)!!
    }

    @Singleton
    @Provides
    fun providesApplicantDao(db: AppDatabase): ApplicantDao = db.applicantDao()
}