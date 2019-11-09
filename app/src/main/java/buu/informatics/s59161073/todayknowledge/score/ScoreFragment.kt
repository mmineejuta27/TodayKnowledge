package buu.informatics.s59161073.todayknowledge.score


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59161073.todayknowledge.R
import buu.informatics.s59161073.todayknowledge.database.GameScoreDatabase
import buu.informatics.s59161073.todayknowledge.databinding.FragmentScoreBinding

/**
 * A simple [Fragment] subclass.
 */
class ScoreFragment : Fragment() {

    private lateinit var viewModel: ScoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var args = ScoreFragmentArgs.fromBundle(arguments!!)

        Toast.makeText(context,"name : ${args.userName} group : ${args.groupButton} score : ${args.scoreGame}", Toast.LENGTH_LONG).show()
        val binding = DataBindingUtil.inflate<FragmentScoreBinding>(inflater,
            R.layout.fragment_score,container,false)

        val application = requireNotNull(this.activity).application

        val dataSource = GameScoreDatabase.getInstance(application).gameScoreDatabaseDao

        val viewModelFactory = ScoreViewModelFactory(dataSource, application)

        Log.i("ScoreFragment", "Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ScoreViewModel::class.java)

        binding.scoreViewModel = viewModel

        binding.lifecycleOwner = this


        viewModel.setScore(args.groupButton,args.userName,args.scoreGame)

        viewModel.flag.observe(this, Observer {
            binding.groupText.text = viewModel.groupText.value
            binding.nameText.text = viewModel.nameText.value
            binding.scoreText.text = viewModel.scoreText.value
        })

        viewModel.start.observe(this, Observer {
            Log.i("InsertScoreDB", "${args.userName}  Score : ${args.scoreGame}")

            viewModel.insertScore(args.userName, args.scoreGame)
        })


        binding.mainButton.setOnClickListener {
                view -> view.findNavController().navigate(R.id.action_scoreFragment_to_userFragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun getShareIntent() : Intent {
        var args = ScoreFragmentArgs.fromBundle(arguments!!)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_success_text, args.userName , args.scoreGame))
        return shareIntent
    }

    // Starting an Activity with our new Intent
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    // Showing the Share Menu Item Dynamically
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu.findItem(R.id.shareItem)?.setVisible(false)
        }
    }

    // Sharing from the Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.shareItem -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }


}
