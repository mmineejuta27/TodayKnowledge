package buu.informatics.s59161073.todayknowledge.grouping


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59161073.todayknowledge.R
import buu.informatics.s59161073.todayknowledge.databinding.FragmentGroupingBinding

/**
 * A simple [Fragment] subclass.
 */
class GroupingFragment : Fragment() {

//    private lateinit var viewModel: GroupingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var args = GroupingFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(context,"name : ${args.userName}",Toast.LENGTH_LONG).show()
        Log.i("User","${args.userName}")
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGroupingBinding>(inflater,
            R.layout.fragment_grouping,container,false)

//        Log.i("GroupingFragment", "Called ViewModelProviders.of")
//        viewModel = ViewModelProviders.of(this).get(GroupingViewModel::class.java)

        binding.fruitButton.setOnClickListener {
                view -> view.findNavController().navigate(
            GroupingFragmentDirections.actionGroupingFragmentToVocabFragment(
                2,
                args.userName
            )
        )
        }
        binding.jobButton.setOnClickListener {
                view -> view.findNavController().navigate(
            GroupingFragmentDirections.actionGroupingFragmentToVocabFragment(
                1,
                args.userName
            )
        )
        }
        binding.colorButton.setOnClickListener {
                view -> view.findNavController().navigate(
            GroupingFragmentDirections.actionGroupingFragmentToVocabFragment(
                4,
                args.userName
            )
        )
        }
        binding.animalButton.setOnClickListener {
                view -> view.findNavController().navigate(
            GroupingFragmentDirections.actionGroupingFragmentToVocabFragment(
                3,
                args.userName
            )
        )
        }
        return binding.root
    }


}
