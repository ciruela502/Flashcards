package martakonik.flashcards.addFlashcard

import android.content.res.Resources
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableInt
import android.view.View
import martakonik.flashcards.Database
import martakonik.flashcards.R
import martakonik.flashcards.utils.SnackbarHelper

class AddFlashCardActivityViewModel(
        private val database: Database,
        @get: Bindable
        val adapter: AddFlashcardAdapter,
        private val snackbarHelper: SnackbarHelper,
        private val boxId: Int,
        private val resources: Resources
) : BaseObservable() {

    @get: Bindable
    val boxName = database.getBox(boxId)?.name ?: ""

    @get: Bindable
    var currentPage = ObservableInt(0)

    @get: Bindable("currentPage")
    var buttonText = resources.getString(R.string.next)
        get() = if (currentPage.get() == 0) {
            resources.getString(R.string.next)
        } else resources.getString(R.string.add)

    fun saveFlashcard(view: View) {
        if (currentPage.get() == 0) {
            currentPage.set(1)
        } else {
            val flashcard = adapter.createFlashcardFromProvidedInfo().apply {
                this?.boxId = boxId
            }
            if (flashcard != null) {
                database.addFlashcard(flashcard, boxId)
                snackbarHelper.showSnackbar(R.string.add_flashcard_succes_message)
                clean()
            } else {
                snackbarHelper.showSnackbar(R.string.empty_fields_message)
            }
        }
    }

    private fun clean() {
        currentPage.set(0)
    }
}