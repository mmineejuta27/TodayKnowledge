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
        var args =
            VocabFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(context,"name : ${args.userName} group : ${args.groupButton}", Toast.LENGTH_LONG).show()
        val binding = DataBindingUtil.inflate<FragmentVocabBinding>(inflater,
            R.layout.fragment_vocab,container,false)

        Log.i("VocabFragment", "Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(VocabViewModel::class.java)

        var groupVocabText : TextView = binding.groupVocabText
        var vocabImage1 : ImageView = binding.vocabImage1
        var vocabText1 : TextView = binding.vocabText1
        var vocabImage2 : ImageView = binding.vocabImage2
        var vocabText2 : TextView = binding.vocabText2
        var vocabImage3 : ImageView = binding.vocabImage3
        var vocabText3 : TextView = binding.vocabText3
        var vocabImage4 : ImageView = binding.vocabImage4
        var vocabText4 : TextView = binding.vocabText4

        if (args.groupButton == 1 ) {
            groupVocabText.text = "JOB"
            vocabImage1.setImageResource(R.drawable.nurse)
            vocabText1.text = "Nurse : นางพยาบาล"
            vocabImage2.setImageResource(R.drawable.policeman)
            vocabText2.text = "Policeman : ตำรวจ"
            vocabImage3.setImageResource(R.drawable.teacher)
            vocabText3.text = "Teacher : คุณครู"
            vocabImage4.setImageResource(R.drawable.doctor)
            vocabText4.text = "Doctor : หมอ"

        }else if (args.groupButton == 2){
            vocabImage1.setImageResource(R.drawable.apple)
            vocabText1.text = "Apple : แอบเปิ้ล"
            vocabImage2.setImageResource(R.drawable.pumpkin)
            vocabText2.text = "Pumpkin : ฟักทอง"
            vocabImage3.setImageResource(R.drawable.watermelon)
            vocabText3.text = "Watermelon : แตงโม"
            vocabImage4.setImageResource(R.drawable.banana)
            vocabText4.text = "Banana : กล้วย"

        }else if (args.groupButton == 3 ){
            vocabImage1.setImageResource(R.drawable.tiger)
            vocabText1.text = "Tiger : เสือ"
            vocabImage2.setImageResource(R.drawable.bird)
            vocabText2.text = "Bird : นก"
            vocabImage3.setImageResource(R.drawable.clownfish)
            vocabText3.text = "Fish : ปลา"
            vocabImage4.setImageResource(R.drawable.duckling)
            vocabText4.text = "Duck : เป็ด"

        } else if (args.groupButton == 4 ){
            vocabImage1.setImageResource(R.drawable.buttonblue)
            vocabText1.text = "Blue : สีฟ้า"
            vocabImage2.setImageResource(R.drawable.buttongreen)
            vocabText2.text = "Green : สีเขียว"
            vocabImage3.setImageResource(R.drawable.buttonred)
            vocabText3.text = "Red : สีแดง"
            vocabImage4.setImageResource(R.drawable.buttonyellow)
            vocabText4.text = "Yellow : สีเหลือง"

        }

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
