package martakonik.flashcards.flashcardsList

import android.databinding.BaseObservable
import android.databinding.Bindable
import martakonik.flashcards.Database

class FlashcardsListViewModel(database: Database) : BaseObservable() {

    @get: Bindable
    val adapter = database.getFlashcardsList()?.let { WordsListAdapter(it) }
}