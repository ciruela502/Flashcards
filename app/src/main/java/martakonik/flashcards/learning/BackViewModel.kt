package martakonik.flashcards.learning

import android.databinding.BaseObservable
import android.databinding.Bindable
import martakonik.flashcards.models.Flashcard

class BackViewModel(flashcard: Flashcard) : BaseObservable() {

    @get:Bindable
    val translation = flashcard.translation
}