package buu.informatics.s59161073.todayknowledge


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59161073.todayknowledge.databinding.FragmentScoreBinding

/**
 * A simple [Fragment] subclass.
 */
class ScoreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var args = ScoreFragmentArgs.fromBundle(arguments!!)

        Toast.makeText(context,"name : ${args.userName} group : ${args.groupButton} score : ${args.scoreGame}", Toast.LENGTH_LONG).show()
        val binding = DataBindingUtil.inflate<FragmentScoreBinding>(inflater,
            R.layout.fragment_score,container,false)
        var groupText : TextView = binding.groupText
        var nameText : TextView = binding.nameText
        var scoreText : TextView = binding.scoreText


        if (args.groupButton == 1 ){
            groupText.text = "JOB"
            nameText.text = args.userName
            scoreText.text = "${args.scoreGame} Score"
        }else if (args.groupButton == 2){
            groupText.text = "FRUIT"
            nameText.text = args.userName
            scoreText.text = "${args.scoreGame} Score"
        }else if (args.groupButton == 3){
            groupText.text = "ANIMAL"
            nameText.text = args.userName
            scoreText.text = "${args.scoreGame} Score"
        }else if (args.groupButton == 4){
            groupText.text = "COLOR"
            nameText.text = args.userName
            scoreText.text = "${args.scoreGame} Score"
        }

        binding.mainButton.setOnClickListener {
                view -> view.findNavController().navigate(R.id.action_scoreFragment_to_userFragment)
        }
        return binding.root
    }


}
