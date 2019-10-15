package buu.informatics.s59161073.todayknowledge


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import buu.informatics.s59161073.todayknowledge.databinding.FragmentExerciseBinding

/**
 * A simple [Fragment] subclass.
 */
class ExerciseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentExerciseBinding>(inflater,
            R.layout.fragment_exercise,container,false)


        return binding.root
    }


}
