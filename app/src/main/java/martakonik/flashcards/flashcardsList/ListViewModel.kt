package martakonik.flashcards.flashcardsList

import android.databinding.BaseObservable
import android.databinding.Bindable
import martakonik.flashcards.models.Flashcard

class ListViewModel(flashcard: Flashcard?) : BaseObservable() {

    @get: Bindable
    val translation = flashcard?.translation ?: ""

    @get: Bindable
    val word = flashcard?.word ?: ""

}