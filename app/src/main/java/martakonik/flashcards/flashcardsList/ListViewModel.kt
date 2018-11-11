package martakonik.flashcards.flashcardsList

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import martakonik.flashcards.models.Flashcard
import martakonik.flashcards.utils.Navigator

class ListViewModel(
        private val flashcard: Flashcard?,
        private val navigator: Navigator
) : BaseObservable() {

    @get: Bindable
    val translation = flashcard?.translation ?: ""

    @get: Bindable
    val word = flashcard?.word ?: ""

    fun openEdit(view: View) {
        flashcard?.id?.let { navigator.openEditActivity(it) }
    }
}