package buu.informatics.s59161073.todayknowledge


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59161073.todayknowledge.databinding.FragmentExerciseBinding
import org.w3c.dom.Text

/**
 * A simple [Fragment] subclass.
 */
class ExerciseFragment : Fragment() {

    data class Exercise(
        val text: String,
        val images: List<Int>
    )

    private val exercises: MutableList<Exercise> = mutableListOf(
        Exercise(text = "waterMelon",
            images = listOf(R.drawable.watermelon, R.drawable.banana, R.drawable.pumpkin, R.drawable.apple)),
        Exercise(text = "apple",
            images = listOf(R.drawable.apple, R.drawable.banana, R.drawable.pumpkin, R.drawable.watermelon)),
        Exercise(text = "pumpkin",
            images = listOf(R.drawable.pumpkin, R.drawable.banana, R.drawable.apple, R.drawable.watermelon)),
        Exercise(text = "banana",
            images = listOf(R.drawable.banana, R.drawable.apple, R.drawable.pumpkin, R.drawable.watermelon))
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
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_exercise,container,false)

        randomizeExercise()

        binding.ansButton1.setOnClickListener {
            view ->
            if (questionIndex >= exercises.size-1){
                view.findNavController().navigate(R.id.action_exerciseFragment_to_scoreFragment)
            }else{
                questionIndex++
                currentExercise = exercises[questionIndex]
                setQuestion()
                binding.invalidateAll()
            }
//                view -> view.findNavController().navigate(R.id.action_exerciseFragment_to_scoreFragment)
        }
        binding.ansButton2.setOnClickListener {
                view -> view.findNavController().navigate(R.id.action_exerciseFragment_to_scoreFragment)
        }
        binding.ansButton3.setOnClickListener {
                view -> view.findNavController().navigate(R.id.action_exerciseFragment_to_scoreFragment)
        }
        binding.ansButton4.setOnClickListener {
                view -> view.findNavController().navigate(R.id.action_exerciseFragment_to_scoreFragment)
        }

        return binding.root
    }

    private fun randomizeExercise() {
        exercises.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion(){
        val textQuestion : TextView = binding.exerciseText

        currentExercise = exercises[questionIndex]

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
