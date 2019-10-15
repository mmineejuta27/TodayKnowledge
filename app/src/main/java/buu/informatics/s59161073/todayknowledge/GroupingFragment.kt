package buu.informatics.s59161073.todayknowledge


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import buu.informatics.s59161073.todayknowledge.databinding.FragmentGroupingBinding

/**
 * A simple [Fragment] subclass.
 */
class GroupingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGroupingBinding>(inflater,
            R.layout.fragment_grouping,container,false)
        return binding.root
    }


}
