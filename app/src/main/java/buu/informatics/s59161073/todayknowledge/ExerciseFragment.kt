package buu.informatics.s59161073.todayknowledge


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59161073.todayknowledge.databinding.FragmentExerciseBinding
import org.w3c.dom.Text

/**
 * A simple [Fragment] subclass.
 */
class ExerciseFragment : Fragment() {
    var checkValue : Int = 0

    data class Exercise(
        val text: String,
        val images: List<Int>
    )
    private val exercises2: MutableList<Exercise> = mutableListOf(
            Exercise(text = "waterMelon",
                images = listOf(R.drawable.watermelon, R.drawable.banana, R.drawable.pumpkin, R.drawable.apple)),
            Exercise(text = "apple",
                images = listOf(R.drawable.apple, R.drawable.banana, R.drawable.pumpkin, R.drawable.watermelon)),
            Exercise(text = "pumpkin",
                images = listOf(R.drawable.pumpkin, R.drawable.banana, R.drawable.apple, R.drawable.watermelon)),
            Exercise(text = "banana",
                images = listOf(R.drawable.banana, R.drawable.apple, R.drawable.pumpkin, R.drawable.watermelon))

    )

    private val exercises1: MutableList<Exercise> = mutableListOf(
        Exercise(text = "Teacher",
            images = listOf(R.drawable.teacher, R.drawable.doctor, R.drawable.policeman, R.drawable.nurse)),
        Exercise(text = "Doctor",
            images = listOf(R.drawable.doctor, R.drawable.policeman, R.drawable.nurse, R.drawable.teacher)),
        Exercise(text = "Nurse",
            images = listOf(R.drawable.nurse, R.drawable.policeman, R.drawable.teacher, R.drawable.doctor)),
        Exercise(text = "Policeman",
            images = listOf(R.drawable.policeman, R.drawable.nurse, R.drawable.teacher, R.drawable.doctor))
    )

    private val exercises3: MutableList<Exercise> = mutableListOf(
        Exercise(text = "Bird",
            images = listOf(R.drawable.bird, R.drawable.clownfish, R.drawable.tiger, R.drawable.duckling)),
        Exercise(text = "Fish",
            images = listOf(R.drawable.clownfish, R.drawable.bird, R.drawable.duckling, R.drawable.tiger)),
        Exercise(text = "Duck",
            images = listOf(R.drawable.duckling, R.drawable.clownfish, R.drawable.bird, R.drawable.tiger)),
        Exercise(text = "Tiger",
            images = listOf(R.drawable.tiger, R.drawable.clownfish, R.drawable.bird, R.drawable.duckling))
    )
    private val exercises4: MutableList<Exercise> = mutableListOf(
        Exercise(text = "Red",
            images = listOf(R.drawable.buttonred, R.drawable.buttonblue, R.drawable.buttongreen, R.drawable.buttonyellow)),
        Exercise(text = "Yellow",
            images = listOf(R.drawable.buttonyellow, R.drawable.buttonred, R.drawable.buttonblue, R.drawable.buttongreen)),
        Exercise(text = "Blue",
            images = listOf(R.drawable.buttonblue, R.drawable.buttonred, R.drawable.buttonyellow, R.drawable.buttongreen)),
        Exercise(text = "Green",
            images = listOf(R.drawable.buttongreen, R.drawable.buttonred, R.drawable.buttonblue, R.drawable.buttonyellow))
    )

    lateinit var currentExercise: Exercise
    lateinit var answers: MutableList<Int>
    private var questionIndex = 0

    private  lateinit var binding: FragmentExerciseBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var args = VocabFragmentArgs.fromBundle(arguments!!)

        Toast.makeText(context,"name : ${args.userName} group : ${args.groupButton}", Toast.LENGTH_LONG).show()
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_exercise,container,false)
        var valueGroping = args.groupButton

        val exerciseResource = when (valueGroping) {
            1 -> exercises1
            2 -> exercises2
            3 -> exercises3
            else -> exercises4
        }

        randomizeExercise(args.groupButton)

        binding.ansButton1.setOnClickListener {
            view ->
            if (questionIndex >= exerciseResource.size-1){
                checkAns(0)
                view.findNavController().navigate(ExerciseFragmentDirections.actionExerciseFragmentToScoreFragment(args.groupButton,args.userName,checkValue))
            }else{
                checkAns(0)
                questionIndex++
                currentExercise = exerciseResource[questionIndex]
                setQuestion(args.groupButton)
                binding.invalidateAll()
            }
        }
        binding.ansButton2.setOnClickListener { view ->
            if (questionIndex >= exerciseResource.size-1){
                checkAns(1)
                view.findNavController().navigate(ExerciseFragmentDirections.actionExerciseFragmentToScoreFragment(args.groupButton, args.userName, checkValue))
            }else{
                checkAns(1)
                questionIndex++
                currentExercise = exerciseResource[questionIndex]
                setQuestion(args.groupButton)
                binding.invalidateAll()
            }
        }
        binding.ansButton3.setOnClickListener {
                view ->
            if (questionIndex >= exerciseResource.size-1){
                checkAns(2)
                view.findNavController().navigate(ExerciseFragmentDirections.actionExerciseFragmentToScoreFragment(args.groupButton, args.userName, checkValue))
            }else{
                checkAns(2)
                questionIndex++
                currentExercise = exerciseResource[questionIndex]
                setQuestion(args.groupButton)
                binding.invalidateAll()
            }
        }
        binding.ansButton4.setOnClickListener {
                view ->
            if (questionIndex >= exerciseResource.size-1){
                checkAns(3)
                view.findNavController().navigate(ExerciseFragmentDirections.actionExerciseFragmentToScoreFragment(args.groupButton, args.userName ,checkValue))
            }else{
                checkAns(3)
                questionIndex++
                currentExercise = exerciseResource[questionIndex]
                setQuestion(args.groupButton)
                binding.invalidateAll()
            }
        }

        return binding.root
    }

    private fun checkAns(index:Int) {
        if(answers[index] == currentExercise.images[0]){
            checkValue = checkValue + 150
            Toast.makeText(context,"Correct : ${checkValue}",Toast.LENGTH_LONG).show()
            Log.i("checlAns","${checkValue}")
        }else{
            Toast.makeText(context,"Not Correct : ${checkValue}",Toast.LENGTH_LONG).show()
        }
    }

    private fun randomizeExercise(group: Int) {
        if(group == 1){
            exercises1.shuffle()
        }else if (group == 2){
            exercises2.shuffle()
        }else if (group == 3){
            exercises3.shuffle()
        }else {
            exercises4.shuffle()
        }
//        exercises1.shuffle()
        questionIndex = 0
        setQuestion(group)
    }

    private fun setQuestion(group: Int){
        val textQuestion : TextView = binding.exerciseText
        if(group == 1){
            currentExercise = exercises1[questionIndex]
        }else if (group == 2){
            currentExercise = exercises2[questionIndex]
        }else if (group == 3){
            currentExercise = exercises3[questionIndex]
        }else {
            currentExercise = exercises4[questionIndex]
        }

        answers = currentExercise.images.toMutableList()
        answers.shuffle()
        textQuestion.setText(currentExercise.text)
        setAnswers()
    }

    private fun setAnswers() {
        val ImageButton1 : Button = binding.ansButton1
        val ImageButton2 : Button = binding.ansButton2
        val ImageButton3 : Button = binding.ansButton3
        val ImageButton4 : Button = binding.ansButton4

        ImageButton1.setBackgroundResource(answers[0])
        ImageButton2.setBackgroundResource(answers[1])
        ImageButton3.setBackgroundResource(answers[2])
        ImageButton4.setBackgroundResource(answers[3])
    }

}
