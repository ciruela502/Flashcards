package martakonik.flashcards.learning

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import martakonik.fiszki.domain.models.Flashcard
import martakonik.flashcards.databinding.FragmentLearningBinding
import martakonik.flashcards.services.MockedBoxService

class LearningFragment : Fragment() {
    private lateinit var binding: FragmentLearningBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLearningBinding.inflate(inflater, container, false)
        binding.viewModel = LearningViewModel()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}