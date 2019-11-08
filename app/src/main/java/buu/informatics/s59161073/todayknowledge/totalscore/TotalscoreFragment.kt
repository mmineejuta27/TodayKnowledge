package buu.informatics.s59161073.todayknowledge.totalscore


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import buu.informatics.s59161073.todayknowledge.R
import buu.informatics.s59161073.todayknowledge.databinding.FragmentTotalscoreBinding

/**
 * A simple [Fragment] subclass.
 */
class TotalscoreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var args =
            TotalscoreFragmentArgs.fromBundle(arguments!!)
        val binding = DataBindingUtil.inflate<FragmentTotalscoreBinding>(inflater,
            R.layout.fragment_totalscore,container,false)

        val adapter = TotalscoreAdapter()
        binding.totalScoreList.adapter = adapter
        binding.setLifecycleOwner(this)

        return binding.root
    }


}
