package martakonik.flashcards.flashcardsList

import android.databinding.BaseObservable
import android.databinding.Bindable
import martakonik.flashcards.Database

class FlashcardsListViewModel(
        @get: Bindable
        val adapter: WordsListAdapter?,
        private val database: Database,
        private val boxId: Int) : BaseObservable() {

        @get: Bindable
        val boxName = database.getBox(boxId)?.name ?: ""
}