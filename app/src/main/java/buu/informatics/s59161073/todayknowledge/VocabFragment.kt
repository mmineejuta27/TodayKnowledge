package buu.informatics.s59161073.todayknowledge


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59161073.todayknowledge.databinding.FragmentVocabBinding

/**
 * A simple [Fragment] subclass.
 */
class VocabFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var args = VocabFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(context,"name : ${args.userName} group : ${args.groupButton}", Toast.LENGTH_LONG).show()
        val binding = DataBindingUtil.inflate<FragmentVocabBinding>(inflater,
            R.layout.fragment_vocab,container,false)

        binding.exerciseButton.setOnClickListener {
                view -> view.findNavController().navigate(R.id.action_vocabFragment_to_exerciseFragment)
        }
        return binding.root
    }


}
