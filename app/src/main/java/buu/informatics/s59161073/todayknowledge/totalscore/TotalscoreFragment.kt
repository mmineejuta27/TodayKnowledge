package buu.informatics.s59161073.todayknowledge.totalscore


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import buu.informatics.s59161073.todayknowledge.R
import buu.informatics.s59161073.todayknowledge.database.GameScoreDatabase
import buu.informatics.s59161073.todayknowledge.databinding.FragmentTotalscoreBinding
import buu.informatics.s59161073.todayknowledge.score.ScoreViewModel
import buu.informatics.s59161073.todayknowledge.score.ScoreViewModelFactory
import androidx.lifecycle.Observer

/**
 * A simple [Fragment] subclass.
 */
class TotalscoreFragment : Fragment() {

    private lateinit var viewModel: ScoreViewModel

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

        val application = requireNotNull(this.activity).application

        val dataSource = GameScoreDatabase.getInstance(application).gameScoreDatabaseDao

        val viewModelFactory = ScoreViewModelFactory(dataSource, application)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ScoreViewModel::class.java)


        viewModel.allScore.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

        return binding.root
    }


}
