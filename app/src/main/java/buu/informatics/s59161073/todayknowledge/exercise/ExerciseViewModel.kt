package buu.informatics.s59161073.todayknowledge.exercise

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import buu.informatics.s59161073.todayknowledge.R

class ExerciseViewModel : ViewModel() {

    var checkValue : Int = 0
    var questionIndex = 0
    var valueGroping: String = "0"

    data class Exercise(
        val text: String,
        val images: List<Int>
    )
    val exercises2: MutableList<Exercise> = mutableListOf(
        Exercise(
            text = "Watermelon",
            images = listOf(
                R.drawable.watermelon,
                R.drawable.banana,
                R.drawable.pumpkin,
                R.drawable.apple
            )
        ),
        Exercise(
            text = "Apple",
            images = listOf(
                R.drawable.apple,
                R.drawable.banana,
                R.drawable.pumpkin,
                R.drawable.watermelon
            )
        ),
        Exercise(
            text = "Pumpkin",
            images = listOf(
                R.drawable.pumpkin,
                R.drawable.banana,
                R.drawable.apple,
                R.drawable.watermelon
            )
        ),
        Exercise(
            text = "Banana",
            images = listOf(
                R.drawable.banana,
                R.drawable.apple,
                R.drawable.pumpkin,
                R.drawable.watermelon
            )
        )

    )

    val exercises1: MutableList<Exercise> = mutableListOf(
        Exercise(
            text = "Teacher",
            images = listOf(
                R.drawable.teacher,
                R.drawable.doctor,
                R.drawable.policeman,
                R.drawable.nurse
            )
        ),
        Exercise(
            text = "Doctor",
            images = listOf(
                R.drawable.doctor,
                R.drawable.policeman,
                R.drawable.nurse,
                R.drawable.teacher
            )
        ),
        Exercise(
            text = "Nurse",
            images = listOf(
                R.drawable.nurse,
                R.drawable.policeman,
                R.drawable.teacher,
                R.drawable.doctor
            )
        ),
        Exercise(
            text = "Policeman",
            images = listOf(
                R.drawable.policeman,
                R.drawable.nurse,
                R.drawable.teacher,
                R.drawable.doctor
            )
        )
    )

    val exercises3: MutableList<Exercise> = mutableListOf(
        Exercise(
            text = "Bird",
            images = listOf(
                R.drawable.bird,
                R.drawable.clownfish,
                R.drawable.tiger,
                R.drawable.duckling
            )
        ),
        Exercise(
            text = "Fish",
            images = listOf(
                R.drawable.clownfish,
                R.drawable.bird,
                R.drawable.duckling,
                R.drawable.tiger
            )
        ),
        Exercise(
            text = "Duck",
            images = listOf(
                R.drawable.duckling,
                R.drawable.clownfish,
                R.drawable.bird,
                R.drawable.tiger
            )
        ),
        Exercise(
            text = "Tiger",
            images = listOf(
                R.drawable.tiger,
                R.drawable.clownfish,
                R.drawable.bird,
                R.drawable.duckling
            )
        )
    )
    val exercises4: MutableList<Exercise> = mutableListOf(
        Exercise(
            text = "Red",
            images = listOf(
                R.drawable.buttonred,
                R.drawable.buttonblue,
                R.drawable.buttongreen,
                R.drawable.buttonyellow
            )
        ),
        Exercise(
            text = "Yellow",
            images = listOf(
                R.drawable.buttonyellow,
                R.drawable.buttonred,
                R.drawable.buttonblue,
                R.drawable.buttongreen
            )
        ),
        Exercise(
            text = "Blue",
            images = listOf(
                R.drawable.buttonblue,
                R.drawable.buttonred,
                R.drawable.buttonyellow,
                R.drawable.buttongreen
            )
        ),
        Exercise(
            text = "Green",
            images = listOf(
                R.drawable.buttongreen,
                R.drawable.buttonred,
                R.drawable.buttonblue,
                R.drawable.buttonyellow
            )
        )
    )

    lateinit var answers: MutableList<Int>



    private val _currentExercise = MutableLiveData<Exercise>()
    val currentExercise : LiveData<Exercise>
        get() = _currentExercise

    private val _currentAnswer = MutableLiveData<MutableList<Int>>()
    val currentAnswer : LiveData<MutableList<Int>>
        get() = _currentAnswer

    private val _ABC = MutableLiveData<Boolean>()
    val ABC : LiveData<Boolean>
        get() = _ABC

    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    init {
        Log.i("ExerciseViewModel", "ExerciseViewModel created!")
        _ABC.value = true
    }

    val exerciseResource = when (valueGroping) {
        "1" -> exercises1
        "2"-> exercises2
        "3" -> exercises3
        else -> exercises4
    }



    fun setvalueGroping(num: Int){
        valueGroping = num.toString()
        randomizeExercise(valueGroping.toInt())
        setQuestion(valueGroping.toInt())

    }

    fun randomizeExercise(group: Int) {
        if(group == 1){
            exercises1.shuffle()
        }else if (group == 2){
            exercises2.shuffle()
        }else if (group == 3){
            exercises3.shuffle()
        }else if (group == 4){
            exercises4.shuffle()
        }
        questionIndex = 0
    }

    fun setQuestion(group: Int){
//        val textQuestion : TextView = binding.exerciseText
        Log.i("setQuestion", "{${group}}")
        if(group == 1){
            _currentExercise.value = exercises1[questionIndex]
        }else if (group == 2){
            _currentExercise.value = exercises2[questionIndex]
        }else if (group == 3){
            _currentExercise.value = exercises3[questionIndex]
        }else{
            _currentExercise.value = exercises4[questionIndex]
        }

        answers = _currentExercise.value!!.images.toMutableList()
        answers.shuffle()
        Log.i("ExerciseViewModel", "${answers}")
        _currentAnswer.value = answers
//        textQuestion.setText(currentExercise.text)
    }

    fun hasClick(index: Int){
        if (questionIndex >= exerciseResource.size-1){
            checkAns(index)
            onGameFinish()
        }else{
            checkAns(index)
            questionIndex++
            _currentExercise.value = exerciseResource[questionIndex]
            setQuestion(valueGroping.toInt())
        }
    }

    fun checkAns(index:Int) {
        if(answers[index] == _currentExercise.value!!.images[0]){
            checkValue = checkValue + 150
        }
    }

    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }

    fun onGameFinish() {
        _eventGameFinish.value = true
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ExerciseViewModel", "ExerciseViewModel destroyed!")
    }
}