package martakonik.flashcards.addFlashcard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import martakonik.flashcards.BaseFragment
import martakonik.flashcards.databinding.FragmentAddFlashcardFrontBinding
import martakonik.flashcards.editFlashcards.FLASHCARD_ID
import martakonik.flashcards.models.Flashcard

class AddFlashcardFragmentFront : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentAddFlashcardFrontBinding.inflate(inflater, container, false)
        val flashcardId = arguments?.getInt(FLASHCARD_ID)
        var flashcard: Flashcard? = Flashcard()
        flashcardId?.let {
            flashcard = database.getFlashcard(it)
        }
        binding.viewModel = flashcard
        return binding.root
    }

    companion object {
        fun create(flashcardId: Int): AddFlashcardFragmentFront {
            val args = Bundle().apply {
                if (flashcardId != NON_EXISTING_ID) {
                    putInt(FLASHCARD_ID, flashcardId)
                }
            }
            return AddFlashcardFragmentFront().apply {
                arguments = args
            }
        }
    }
}