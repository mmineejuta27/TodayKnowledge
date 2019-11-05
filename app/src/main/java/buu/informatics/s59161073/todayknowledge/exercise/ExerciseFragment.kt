package buu.informatics.s59161073.todayknowledge.exercise


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59161073.todayknowledge.exercise.ExerciseFragmentDirections
import buu.informatics.s59161073.todayknowledge.R
import buu.informatics.s59161073.todayknowledge.vocab.VocabFragmentArgs
import buu.informatics.s59161073.todayknowledge.databinding.FragmentExerciseBinding
import buu.informatics.s59161073.todayknowledge.score.ScoreViewModel

/**
 * A simple [Fragment] subclass.
 */
class ExerciseFragment : Fragment() {

    lateinit var answers: MutableList<Int>
    private var questionIndex = 0

    private  lateinit var binding: FragmentExerciseBinding
    private lateinit var viewModel: ExerciseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var args =
            VocabFragmentArgs.fromBundle(arguments!!)

        Toast.makeText(context,"name : ${args.userName} group : ${args.groupButton}", Toast.LENGTH_LONG).show()
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_exercise,container,false)

        Log.i("ExerciseFragment", "Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(ExerciseViewModel::class.java)



        binding.exerciseViewModel = viewModel

        binding.lifecycleOwner = this

        viewModel.ABC.observe(this, Observer { newABC ->
            viewModel.setvalueGroping(args.groupButton)
        })

        viewModel.eventGameFinish.observe(this, Observer {
            viewModel.eventGameFinish.observe(this, Observer<Boolean> { hasFinished ->
                if (hasFinished) hasFinish(args.userName, args.groupButton, viewModel.checkValue)
            })
        })

        viewModel.currentExercise.observe(this, Observer { newExercise ->
            binding.exerciseText.text = newExercise.text
        })

        viewModel.valueGroping = args.groupButton.toString()

        viewModel.currentAnswer.observe(this, Observer { newAnswer ->
            binding.ansButton1.setBackgroundResource(newAnswer[0])
            binding.ansButton2.setBackgroundResource(newAnswer[1])
            binding.ansButton3.setBackgroundResource(newAnswer[2])
            binding.ansButton4.setBackgroundResource(newAnswer[3])


        })

        return binding.root
    }

    private fun hasFinish(username : String, group : Int, score: Int){
        view!!.findNavController().navigate(
            ExerciseFragmentDirections.actionExerciseFragmentToScoreFragment(
                group,
                username,
                score
            )
        )
    }

}
