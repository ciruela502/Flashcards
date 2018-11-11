package martakonik.flashcards.flashcardsList

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.support.v7.widget.DividerItemDecoration
import martakonik.flashcards.Database

class FlashcardsListViewModel(
        @get: Bindable
        val adapter: WordsListAdapter?,
        database: Database,
        boxId: Int,
        @get: Bindable
        val decoration: DividerItemDecoration) : BaseObservable() {

    @get: Bindable
    val boxName = database.getBox(boxId)?.name ?: ""
}