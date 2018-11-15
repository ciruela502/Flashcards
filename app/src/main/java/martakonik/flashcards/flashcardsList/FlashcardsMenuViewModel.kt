package martakonik.flashcards.flashcardsList

import android.databinding.BaseObservable
import android.view.View
import martakonik.flashcards.Database
import martakonik.flashcards.R
import martakonik.flashcards.utils.Navigator
import martakonik.flashcards.utils.SnackbarHelper

class FlashcardsMenuViewModel(
        private val flashcardId: Int,
        private val navigator: Navigator?,
        private val database: Database,
        private val snackbarHelper: SnackbarHelper,
        private val flashcardListMenu: FlashcardListMenu
) : BaseObservable() {

    fun onEditClick(view: View) {
        navigator?.openEditActivity(flashcardId)
    }

    fun onDeleteClick(view: View) {
        database.deleteFlashcard(flashcardId)
        flashcardListMenu.dismiss()
        snackbarHelper.showSnackbar(R.string.flashcard_delete)
    }
}