package martakonik.flashcards.addFlashcard

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import martakonik.flashcards.Database
import martakonik.flashcards.R
import martakonik.flashcards.utils.SnackbarHelper

class AddFlashCardActivityViewModel(
        private val database: Database,
        private val snackbarHelper: SnackbarHelper,
        private val adapter: AddFlashcardAdapter,
        private val boxId: Int
) : BaseObservable() {

    @get: Bindable
    val boxName = database.getBox(boxId)?.name ?: ""

    fun saveFlashcard(view: View) {
        val flashcard = adapter.createFlashcardFromProvidedInfo().apply {
            this?.boxId = boxId
        }
        if (flashcard != null) {
            database.addFlashcard(flashcard, boxId)
            snackbarHelper.showSnackbar(R.string.add_flashcard_succes_message)
        } else {
            snackbarHelper.showSnackbar(R.string.empty_fields_message)
        }

    }
}