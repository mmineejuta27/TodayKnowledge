package buu.informatics.s59161073.todayknowledge.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    init {
        Log.i("ScoreViewModel", "ScoreViewModel created!")
    }

    private val _groupText = MutableLiveData<String>()
    val groupText : LiveData<String>
        get() = _groupText

    private val _nameText = MutableLiveData<String>()
    val nameText : LiveData<String>
        get() = _nameText

    private val _scoreText = MutableLiveData<String>()
    val scoreText : LiveData<String>
        get() = _scoreText

    private val _flag = MutableLiveData<Boolean>()
    val flag : LiveData<Boolean>
        get() = _flag

    fun setScore (group :Int,user:String,score:Int){
        if (group == 1 ){
            _groupText.value = "JOB"
            _nameText.value = user
            _scoreText.value = "${score} Score"
        }else if (group == 2){
            _groupText.value = "FRUIT"
            _nameText.value = user
            _scoreText.value = "${score} Score"
        }else if (group == 3){
            _groupText.value = "ANIMAL"
            _nameText.value =  user
            _scoreText.value = "${score} Score"
        }else if (group == 4){
            _groupText.value = "COLOR"
            _nameText.value = user
            _scoreText.value = "${score} Score"
        }

        _flag.value = true
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ScoreViewModel", "ScoreViewModel destroyed!")
    }
}