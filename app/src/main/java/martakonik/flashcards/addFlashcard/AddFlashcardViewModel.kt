package martakonik.flashcards.addFlashcard

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import martakonik.flashcards.Database
import martakonik.flashcards.R
import martakonik.flashcards.models.Flashcard
import martakonik.flashcards.utils.SnackbarHelper

class AddFlashcardViewModel(
        private val database: Database,
        private val snackbarHelper: SnackbarHelper) : BaseObservable() {

    var flashcard = Flashcard()

    @Bindable
    var word = ""
    @Bindable
    var translation = ""

    fun saveFlashcard(view: View) {
        flashcard.word = word
        flashcard.translation = translation

        database.addFlashcard(flashcard)

        cleanEditTexts()

        snackbarHelper.showSnackbar(R.string.add_flashcard_succes_message)

    }

    private fun cleanEditTexts() {
        word = ""
        translation = ""
        notifyChange()
    }
}