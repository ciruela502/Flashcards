package martakonik.flashcards.learning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import martakonik.flashcards.BaseFragment
import martakonik.flashcards.databinding.FragmentCardFrontBinding
import martakonik.flashcards.models.Flashcard

class FrontCardFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentCardFrontBinding.inflate(inflater, container, false)
        val flashcard = arguments?.getParcelable<Flashcard>(CARD)
        binding.viewModel = flashcard?.let { FrontViewModel(it) }

        return binding.root
    }


}