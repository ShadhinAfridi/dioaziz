package com.fourdevs.dioaziz.ui.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStoreManager @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    // Put a Boolean value in DataStore
    suspend fun putBoolean(key: String, value: Boolean) = runBlocking {
        val dataStoreKey = booleanPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences[dataStoreKey] = value
        }
    }

    // Put a String value in DataStore
    suspend fun putString(key: String, value: String) = runBlocking {
        val dataStoreKey = stringPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences[dataStoreKey] = value
        }
    }

    // Get a Boolean value from DataStore
    fun getBoolean(key: String): Flow<Boolean> {
        val dataStoreKey = booleanPreferencesKey(key)
        return dataStore.data.map { preferences ->
            preferences[dataStoreKey] ?: false
        }
    }


    // Get a String value from DataStore
    fun getString(key: String): Flow<String?> {
        val dataStoreKey = stringPreferencesKey(key)
        return dataStore.data.map { preferences ->
            preferences[dataStoreKey]
        }
    }

    // Clear all data in DataStore
    suspend fun clear() = runBlocking {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }
}