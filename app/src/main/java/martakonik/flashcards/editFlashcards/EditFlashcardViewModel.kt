package martakonik.flashcards.editFlashcards

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import martakonik.flashcards.Database
import martakonik.flashcards.R
import martakonik.flashcards.addFlashcard.AddFlashcardAdapter
import martakonik.flashcards.utils.Navigator
import martakonik.flashcards.utils.SnackbarHelper

class EditFlashcardViewModel(
        private val database: Database,
        flashcardId: Int,
        private val snackbarHelper: SnackbarHelper,
        private val adapter: AddFlashcardAdapter,
        private val navigator: Navigator
) : BaseObservable() {
    val flashcard = database.getFlashcard(flashcardId)

    @get: Bindable
    val boxName = flashcard?.boxId?.let { database.getBox(it)?.name } ?: ""

    fun saveFlashcard(view: View) {
        val flashcard = adapter.createFlashcardFromProvidedInfo().apply {
            this?.boxId = flashcard?.boxId ?: 0
            this?.id = flashcard?.id ?: 0
        }
        if (flashcard != null) {
            database.editFlashcard(flashcard)
            navigator.finishCurrentActivity()
            snackbarHelper.showSnackbar(R.string.edit_flashcard)
        } else {
            snackbarHelper.showSnackbar(R.string.empty_fields_message)
        }
    }

    fun deleteFlashcard(): Boolean {
        flashcard?.id?.let { database.deleteFlashcard(it) }
        snackbarHelper.showSnackbar(R.string.flashcard_delete)
        //todo add redo action
        navigator.finishCurrentActivity()
        return true
    }
}