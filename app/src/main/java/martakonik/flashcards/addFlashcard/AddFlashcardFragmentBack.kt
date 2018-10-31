package martakonik.flashcards.addFlashcard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import martakonik.flashcards.BaseFragment
import martakonik.flashcards.databinding.FragmentAddFlashcardBackBinding
import martakonik.flashcards.utils.SnackbarHelper

class AddFlashcardFragmentBack : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentAddFlashcardBackBinding.inflate(inflater, container, false)
//        binding.viewModel = AddFlashcardViewModel(database, SnackbarHelper(binding.root))

        return binding.root
    }
}