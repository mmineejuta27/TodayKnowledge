package buu.informatics.s59161073.todayknowledge.exercise

import android.util.Log
import androidx.lifecycle.ViewModel

class ExerciseViewModel : ViewModel() {
    init {
        Log.i("ExerciseViewModel", "ExerciseViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ExerciseViewModel", "ExerciseViewModel destroyed!")
    }
}