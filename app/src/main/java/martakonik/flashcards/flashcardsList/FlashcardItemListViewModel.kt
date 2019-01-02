package martakonik.flashcards.flashcardsList

import android.content.res.Resources
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.View
import martakonik.flashcards.data.getTitle
import martakonik.flashcards.editFlashcards.FLASHCARD_ID
import martakonik.flashcards.models.Flashcard

class FlashcardItemListViewModel(
        private val flashcard: Flashcard?,
        private val supportFragmentManager: FragmentManager,
        @get: Bindable
        val headerVisible: Boolean,
        resources: Resources
) : BaseObservable() {

    @get: Bindable
    val title = resources.getString(flashcard?.partOfBoxId.getTitle())

    @get: Bindable
    val translation = flashcard?.translation ?: ""

    @get: Bindable
    val word = flashcard?.word ?: ""

    fun openEdit(view: View) {
        val args = Bundle().apply {
            flashcard?.id?.let { putInt(FLASHCARD_ID, it) }
        }
        val bottomFragment = FlashcardListMenu().apply {
            arguments = args
        }
        bottomFragment.show(supportFragmentManager, TAG_EDIT_MENU)
    }
}