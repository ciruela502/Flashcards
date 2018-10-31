package martakonik.flashcards.addFlashcard

import android.databinding.BaseObservable
import android.view.View
import martakonik.flashcards.Database
import martakonik.flashcards.R
import martakonik.flashcards.models.Flashcard
import martakonik.flashcards.utils.SnackbarHelper

class AddFlashCardActivityViewModel(
        private val database: Database,
        private val snackbarHelper: SnackbarHelper,
        private val adapter: AddFlashcardAdapter) : BaseObservable() {

    var flashcard = Flashcard()

    fun saveFlashcard(view: View) {
        val flashcard = adapter.createFlashcardFromProvidedInfo()
        if (flashcard != null) {
            database.addFlashcard(flashcard)
            snackbarHelper.showSnackbar(R.string.add_flashcard_succes_message)
        } else {
            snackbarHelper.showSnackbar(R.string.empty_fields_message)
        }

    }
}