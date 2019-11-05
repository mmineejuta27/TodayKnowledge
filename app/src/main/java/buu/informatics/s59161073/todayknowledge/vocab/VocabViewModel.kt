package buu.informatics.s59161073.todayknowledge.vocab

import android.util.Log
import androidx.lifecycle.ViewModel

class VocabViewModel : ViewModel() {
    init {
        Log.i("VocabViewModel", "VocabViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("VocabViewModel", "VocabViewModel destroyed!")
    }
}