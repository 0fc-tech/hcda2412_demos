package com.example.mod6room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ListMusicViewModel(private val musicDao: MusicDao) : ViewModel() {
    private val _musics = MutableStateFlow<List<Music>>(emptyList())
    val musics: Flow<List<Music>> = _musics
    init {
        viewModelScope.launch {
            insertMusic(
                Music(0L, "Never Gonna Give You Up", "Rick Astley", 220)
            )
            insertMusic(
                Music(0L, "Feel Good", "Polo & Pan", 240)
            )
            loadMusics()
        }
    }
    fun loadMusics() {
        viewModelScope.launch(Dispatchers.IO) {
            _musics.value = musicDao.getAllMusic()
        }
    }
    fun insertMusic(music: Music) {
        viewModelScope.launch(Dispatchers.IO) {
            musicDao.insertMusic(music)
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = object :
            ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application =

                    checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                return ListMusicViewModel(
                    AppDatabase.getInstance(application.applicationContext).musicDao(),
                ) as T
            }
        }
    }
}