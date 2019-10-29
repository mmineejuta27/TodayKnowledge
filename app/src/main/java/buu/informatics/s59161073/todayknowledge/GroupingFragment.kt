package buu.informatics.s59161073.todayknowledge


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59161073.todayknowledge.databinding.FragmentGroupingBinding

/**
 * A simple [Fragment] subclass.
 */
class GroupingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var args = GroupingFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(context,"name : ${args.userName}",Toast.LENGTH_LONG).show()
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGroupingBinding>(inflater,
            R.layout.fragment_grouping,container,false)
        binding.fruitButton.setOnClickListener {
                view -> view.findNavController().navigate(R.id.action_groupingFragment_to_vocabFragment)
        }
        binding.jobButton.setOnClickListener {
                view -> view.findNavController().navigate(R.id.action_groupingFragment_to_vocabFragment)
        }
        binding.colorButton.setOnClickListener {
                view -> view.findNavController().navigate(R.id.action_groupingFragment_to_vocabFragment)
        }
        binding.animalButton.setOnClickListener {
                view -> view.findNavController().navigate(R.id.action_groupingFragment_to_vocabFragment)
        }
        return binding.root
    }


}
