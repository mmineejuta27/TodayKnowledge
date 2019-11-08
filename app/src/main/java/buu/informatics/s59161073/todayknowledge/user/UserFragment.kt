package buu.informatics.s59161073.todayknowledge.user


import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59161073.todayknowledge.R
import buu.informatics.s59161073.todayknowledge.user.UserFragmentDirections
import buu.informatics.s59161073.todayknowledge.databinding.FragmentUserBinding
import buu.informatics.s59161073.todayknowledge.score.ScoreViewModel

/**
 * A simple [Fragment] subclass.
 */
class UserFragment : Fragment() {

    var user: String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentUserBinding>(inflater,
            R.layout.fragment_user,container,false)

        user = binding.inputName.text.toString()
        binding.okButton.setOnClickListener {view ->

            if(user.isEmpty()){
                Toast.makeText(getActivity(), "ช่องว่าง เขียนชื่อด้วยนะ" ,Toast.LENGTH_LONG).show()
                Log.i("User","Not login")
            }else{
                view.findNavController().navigate(
                    UserFragmentDirections.actionUserFragmentToGroupingFragment(
                        user
                    )
                )
                Log.i("User","${user}")
            }

        }

        binding.testBut?.setOnClickListener {view ->
            view.findNavController().navigate(
                UserFragmentDirections.actionUserFragmentToTotalscoreFragment(
                    user
                )
            )
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController()) || super.onOptionsItemSelected(item)
    }


}
