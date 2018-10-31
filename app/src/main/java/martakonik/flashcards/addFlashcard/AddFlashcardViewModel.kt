package martakonik.flashcards.addFlashcard

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import martakonik.flashcards.Database
import martakonik.flashcards.R
import martakonik.flashcards.models.Flashcard
import martakonik.flashcards.utils.SnackbarHelper

class AddFlashcardViewModel() : BaseObservable() {


    @Bindable
    var text = ""

}