package buu.informatics.s59161073.todayknowledge.score

import android.util.Log
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    init {
        Log.i("ScoreViewModel", "ScoreViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ScoreViewModel", "ScoreViewModel destroyed!")
    }
}