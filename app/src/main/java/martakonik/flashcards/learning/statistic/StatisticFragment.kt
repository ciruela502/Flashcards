package martakonik.flashcards.learning.statistic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import martakonik.flashcards.BaseFragment
import martakonik.flashcards.databinding.FragmentStatisticBinding
import martakonik.flashcards.utils.BOX_ID

class StatisticFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentStatisticBinding.inflate(inflater, container, false)
        val boxId = arguments?.getInt(BOX_ID) ?: 0
        binding.viewModel = database.getBox(boxId)?.let { StatisticViewModel(it) }

        return binding.root
    }
}