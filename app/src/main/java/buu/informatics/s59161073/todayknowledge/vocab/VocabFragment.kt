package buu.informatics.s59161073.todayknowledge.vocab


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59161073.todayknowledge.R
import buu.informatics.s59161073.todayknowledge.vocab.VocabFragmentArgs
import buu.informatics.s59161073.todayknowledge.vocab.VocabFragmentDirections
import buu.informatics.s59161073.todayknowledge.databinding.FragmentVocabBinding
import buu.informatics.s59161073.todayknowledge.exercise.ExerciseViewModel

/**
 * A simple [Fragment] subclass.
 */
class VocabFragment : Fragment() {

    private lateinit var viewModel: VocabViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var args = VocabFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(context,"name : ${args.userName} group : ${args.groupButton}", Toast.LENGTH_LONG).show()
        val binding = DataBindingUtil.inflate<FragmentVocabBinding>(inflater,
            R.layout.fragment_vocab,container,false)

        Log.i("VocabFragment", "Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(VocabViewModel::class.java)

        binding.vocabViewModel = viewModel

        binding.lifecycleOwner = this

        viewModel.setVocab(args.groupButton)

        viewModel.flag.observe(this, Observer {
            binding.groupVocabText.text = viewModel.groupVocabText.value

            binding.vocabImage1.setBackgroundResource(viewModel.vocabImage1.value!!)
            binding.vocabText1.text = viewModel.vocabText1.value

            binding.vocabImage2.setBackgroundResource(viewModel.vocabImage2.value!!)
            binding.vocabText2.text = viewModel.vocabText2.value

            binding.vocabImage3.setBackgroundResource(viewModel.vocabImage3.value!!)
            binding.vocabText3.text = viewModel.vocabText3.value

            binding.vocabImage4.setBackgroundResource(viewModel.vocabImage4.value!!)
            binding.vocabText4.text = viewModel.vocabText4.value

        })

        binding.exerciseButton.setOnClickListener {view ->
            view.findNavController().navigate(
                VocabFragmentDirections.actionVocabFragmentToExerciseFragment(
                    args.userName,
                    args.groupButton
                )
            )
        }
        return binding.root
    }



}
