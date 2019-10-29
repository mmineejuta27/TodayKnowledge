package buu.informatics.s59161073.todayknowledge


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59161073.todayknowledge.databinding.FragmentJobBinding

/**
 * A simple [Fragment] subclass.
 */
class JobFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentJobBinding>(inflater,
            R.layout.fragment_vocab,container,false)

        binding.exerciseButton.setOnClickListener {
                view -> view.findNavController().navigate(R.id.action_vocabFragment_to_exerciseFragment)
        }
        return binding.root
    }


}
