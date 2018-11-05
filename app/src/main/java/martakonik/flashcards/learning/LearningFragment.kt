package martakonik.flashcards.learning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import martakonik.flashcards.BaseFragment
import martakonik.flashcards.DecreaseStudyLevelUseCase
import martakonik.flashcards.GetNextCardUseCase
import martakonik.flashcards.IncreaseStudyLevelUseCase
import martakonik.flashcards.databinding.FragmentLearningBinding
import martakonik.flashcards.services.MockedBoxService

const val CARD = "card"

class LearningFragment : BaseFragment() {
    private lateinit var learningViewModel: LearningViewModel
    private lateinit var binding: FragmentLearningBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLearningBinding.inflate(inflater, container, false)

        val boxId : Int = arguments?.getInt(BOX_ID) ?: 0
        val boxService = MockedBoxService(database, boxId)

        learningViewModel = LearningViewModel(
                childFragmentManager,
                IncreaseStudyLevelUseCase(boxService, database),
                DecreaseStudyLevelUseCase(boxService, database),
                GetNextCardUseCase(boxService))
        binding.viewModel = learningViewModel

        return binding.root
    }
}