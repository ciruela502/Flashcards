package martakonik.flashcards.learning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import martakonik.flashcards.BaseFragment
import martakonik.flashcards.databinding.FragmentCardBackBinding
import martakonik.flashcards.models.Flashcard

class BackCardFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentCardBackBinding.inflate(inflater, container, false)
        val flashcard = arguments?.getParcelable<Flashcard>(CARD)
        binding.viewModel = flashcard?.let { BackViewModel(it) }

        return binding.root
    }

}