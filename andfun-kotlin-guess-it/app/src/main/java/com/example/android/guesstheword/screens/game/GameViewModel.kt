package com.example.android.guesstheword.screens.game

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
private const val TAG ="GameViewModel"
class GameViewModel : ViewModel(){
    companion object {
        // These represent different important times
        // This is when the game is over
        const val DONE = 0L
        // This is the number of milliseconds in a second
        const val ONE_SECOND = 1000L
        // This is the total time of the game
        const val COUNTDOWN_TIME = 10000L
    }
    // The current _word
   private var _word = MutableLiveData<String>()
   val word : LiveData<String>
    get() = _word
    // The current _score
    private var _score = MutableLiveData<Int>()
    val score: LiveData<Int>
    get() = _score
    //hasGame Finished
    private var _hasGameFinished = MutableLiveData<Boolean>()
    val hasGameFinished: LiveData<Boolean>
    get() = _hasGameFinished
    private var _time = MutableLiveData<Long>()
    val time : LiveData<Long>
    get() = _time
    private lateinit var wordList: MutableList<String>
    private lateinit var timer: CountDownTimer
    init {
        Log.i(TAG, "View model created")
        resetList()
        nextWord()
        _score.value = 0

        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {

            override fun onTick(millisUntilFinished: Long) {
                _time.value = (millisUntilFinished / ONE_SECOND)
            }

            override fun onFinish() {
                _time.value = DONE
                _hasGameFinished.value = true
            }
        }

        timer.start()
    }

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }


    fun onSkip() {
        _score.value = (_score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _score.value = (_score.value)?.plus(1)
        nextWord()
    }
    /**
     * Moves to the next _word in the list
     */
    private fun nextWord() {
        //Select and remove a _word from the list
        if (wordList.isEmpty()) {
            resetList()
        }
        _word.value = wordList.removeAt(0)

    }

    fun onGameFinishCompleted(){
        _hasGameFinished.value = false
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
        Log.i(TAG, "View model destroyed!")
    }


}