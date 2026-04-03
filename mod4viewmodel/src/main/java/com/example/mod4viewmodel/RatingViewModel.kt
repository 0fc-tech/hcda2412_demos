package com.example.mod4viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RatingViewModel : ViewModel() {
    //Est-ce que la note a été renseignée "ETAT"
    private val _ratingState = MutableStateFlow(false)
    val ratingState = _ratingState.asStateFlow()

    private val _currentRating = MutableStateFlow(5f)
    val currentRating = _currentRating.asStateFlow()

    private val _userAnswer = MutableStateFlow("")
    val userAnswer = _userAnswer.asStateFlow()

    fun updateText(text:String){
        _userAnswer.value = text
    }
    fun updateRating(rating:Float){
        if(rating<8){
            _ratingState.value = false
        }else{
            _ratingState.value = true
            _userAnswer.value = ""
        }
        _currentRating.value = rating
    }
}