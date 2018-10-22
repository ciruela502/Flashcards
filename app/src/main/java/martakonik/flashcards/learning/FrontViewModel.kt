package martakonik.flashcards.learning

import android.databinding.BaseObservable
import android.databinding.Bindable
import martakonik.flashcards.models.Flashcard

class FrontViewModel(flashcard: Flashcard) : BaseObservable() {

    @get: Bindable
    val word = flashcard.word

}