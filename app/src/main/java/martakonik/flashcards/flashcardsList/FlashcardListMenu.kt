package martakonik.flashcards.flashcardsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import martakonik.flashcards.databinding.ViewBottomFlashcardsMenuBinding
import martakonik.flashcards.editFlashcards.FLASHCARD_ID
import martakonik.flashcards.utils.BaseBottomSheetDialogFragment
import martakonik.flashcards.utils.SnackbarHelper

const val TAG_EDIT_MENU = "tag_edit_menu"

class FlashcardListMenu : BaseBottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = ViewBottomFlashcardsMenuBinding.inflate(inflater, container, false)
        val flashcardId = arguments?.getInt(FLASHCARD_ID)
        val viewModel = flashcardId?.let { FlashcardsMenuViewModel(it, navigator, database, SnackbarHelper(binding.root), this) }
        binding.viewModel = viewModel
        return binding.root
    }
}