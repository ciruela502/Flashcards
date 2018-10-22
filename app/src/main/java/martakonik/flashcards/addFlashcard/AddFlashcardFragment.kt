package martakonik.flashcards.addFlashcard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import martakonik.flashcards.BaseFragment
import martakonik.flashcards.databinding.FragmentAddFlashcardBinding
import martakonik.flashcards.utils.SnackbarHelper

class AddFlashcardFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentAddFlashcardBinding.inflate(inflater, container, false)
        binding.viewModel = AddFlashcardViewModel(database, SnackbarHelper(binding.root))

        return binding.root
    }
}