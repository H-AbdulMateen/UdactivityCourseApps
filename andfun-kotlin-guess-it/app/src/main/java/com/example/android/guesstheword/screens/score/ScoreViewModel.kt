package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
private const val TAG = "ScoreViewModel"
class ScoreViewModel(finalScore: Int) : ViewModel(){
    private var _score =MutableLiveData<Int>()
    val score: LiveData<Int>
    get() = _score

    private var _eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain : LiveData<Boolean>
    get() = _eventPlayAgain

    init {
        Log.i(TAG, finalScore.toString())
        _score.value = finalScore
    }

    fun onPlayAgain(){
        _eventPlayAgain.value = true
    }

    fun onPlayAgainCompleted(){
        _eventPlayAgain.value = false
    }
}