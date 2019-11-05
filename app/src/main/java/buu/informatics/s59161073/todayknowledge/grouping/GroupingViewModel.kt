package buu.informatics.s59161073.todayknowledge.grouping

import android.util.Log
import androidx.lifecycle.ViewModel

class GroupingViewModel : ViewModel() {
    init {
        Log.i("GroupingViewModel", "GroupingViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GroupingViewModel", "GroupingViewModel destroyed!")
    }
}