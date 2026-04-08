package com.example.mod6datastore

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class UserPreferencesRepository(private val context: Context) {
    //Clé Preference Background Color
    private val KEY_BG_COLOR_SELECTED = intPreferencesKey("key_bg_color_selected")
    private val Context.dataStore by preferencesDataStore(name = "user_preferences")


    //enregistrer le type de couleur de fond
    suspend fun saveBgColor(color: Color) {
        context.dataStore.edit { pref ->
            pref[KEY_BG_COLOR_SELECTED] = color.toArgb()
        }
    }
    fun getBgColor(): Flow<Color> {
        return context.dataStore.data.map { pref ->
            Color(pref[KEY_BG_COLOR_SELECTED] ?: Color.White.toArgb())
        }
    }


}