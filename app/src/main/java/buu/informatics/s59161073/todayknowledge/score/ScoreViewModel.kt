package buu.informatics.s59161073.todayknowledge.score

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import buu.informatics.s59161073.todayknowledge.database.GameScore
import buu.informatics.s59161073.todayknowledge.database.GameScoreDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.*

class ScoreViewModel (val database: GameScoreDatabaseDao, application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    val allScore = database.getAllGameScore()

    private var gameScore = MutableLiveData<GameScore?>()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name

    val _start = MutableLiveData<Boolean>()
    val start: LiveData<Boolean>
        get() = _start


    init {
        Log.i("ScoreViewModel", "ScoreViewModel created!")
//        clearScore()
        initializeGameScore()
        _start.value = true

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

    fun clearScore() {
        uiScope.launch {
            clear()
        }
    }

    private suspend fun getGameScoreFromDatabase(): GameScore? {
        return withContext(Dispatchers.IO) {
            var score = database.getGameScore()
            score
        }
    }

    private fun initializeGameScore() {
        uiScope.launch {
            gameScore.value = getGameScoreFromDatabase()
        }
    }

    fun insertScore(name : String, score: Int) {
        uiScope.launch {
            val newScore = GameScore()
            newScore.username = name
            newScore.score = score
            insert(newScore)
        }
    }

    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }

    private suspend fun insert(score: GameScore) {
        withContext(Dispatchers.IO) {
            database.insert(score)
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ScoreViewModel", "ScoreViewModel destroyed!")
    }
}