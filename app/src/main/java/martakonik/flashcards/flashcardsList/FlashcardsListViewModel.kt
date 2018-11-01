package martakonik.flashcards.flashcardsList

import android.databinding.BaseObservable
import android.databinding.Bindable
import martakonik.flashcards.Database

class FlashcardsListViewModel(private val database: Database) : BaseObservable() {
    fun updateBox(boxId: Int) {
        adapter = database.getFlashcardsListByBoxId(boxId)?.let { WordsListAdapter(it) }
        notifyChange()
    }

    @get: Bindable
    var adapter: WordsListAdapter? = null
}