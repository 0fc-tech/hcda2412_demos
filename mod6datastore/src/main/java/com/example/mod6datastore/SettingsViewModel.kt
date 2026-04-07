package com.example.mod6datastore

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SettingsViewModel(private val userPreferencesRepository:
                        UserPreferencesRepository) :
    ViewModel() {
    //Liste Des couleurs Disponibles
    private val _colors = MutableStateFlow<List<Color>>(
        listOf(
            Color(0xFF6750A4), // M3 Primary (Purple 40)
            Color(0xFF625B71), // M3 Secondary (Dark Purple 40)
            Color(0xFF7D5260), // M3 Tertiary (Pink 40)
            Color(0xFFB3261E), // M3 Error (Red 40)
            Color(0xFFEADDFF), // M3 Primary Container (Purple 90)
            Color(0xFFFFD8E4), // M3 Tertiary Container (Pink 90)
            Color(0xFFF3EDF7)
        )
    )
    val colors: StateFlow<List<Color>> = _colors

    //Couleur Sélectionnée
    private val _userColor = MutableStateFlow<Color>(Color.White)
    val userColor: StateFlow<Color> = _userColor

    init {
        getBgColor()
    }

    fun getBgColor() {
        viewModelScope.launch {
            userPreferencesRepository.getBgColor().collect {
                _userColor.value = it

            }
        }
    }

    fun setBgColor(color: Color) {
       // _userColor.value = color
        viewModelScope.launch {
            userPreferencesRepository.saveBgColor(color)
        }
    }
    companion object{
        val Factory : ViewModelProvider.Factory = object : ViewModelProvider.Factory{
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: androidx.lifecycle.viewmodel.CreationExtras) : T{
                val application = checkNotNull(
                    extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                )
                val userPreferencesRepository = UserPreferencesRepository(application)
                return SettingsViewModel(userPreferencesRepository) as T
            }
        }
    }
}