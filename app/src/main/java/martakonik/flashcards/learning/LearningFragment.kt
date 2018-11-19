package martakonik.flashcards.learning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import martakonik.flashcards.*
import martakonik.flashcards.databinding.FragmentLearningBinding
import martakonik.flashcards.services.MockedBoxService
import martakonik.flashcards.utils.BOX_ID
import martakonik.flashcards.utils.ShowDialog

const val CARD = "card"

class LearningFragment : BaseFragment() {
    private lateinit var learningViewModel: LearningViewModel
    private lateinit var binding: FragmentLearningBinding
    private lateinit var showDialog: ShowDialog
    private val finish = { finishLearning() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLearningBinding.inflate(inflater, container, false)

        val boxId : Int = arguments?.getInt(BOX_ID) ?: 0
        val boxService = MockedBoxService(database, boxId)
        showDialog = ShowDialog(context)

        learningViewModel = LearningViewModel(
                childFragmentManager,
                IncreaseStudyLevelUseCase(boxService, database),
                DecreaseStudyLevelUseCase(boxService, database),
                GetNextCardUseCase(boxService, finish),
                resources)
        binding.viewModel = learningViewModel

        return binding.root
    }


    private fun finishLearning() {
        showDialog.show(R.string.finish_title, R.string.finish_message, R.string.ok)
    }
}