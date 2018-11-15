package martakonik.flashcards.flashcardsList

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.support.v7.widget.DividerItemDecoration
import android.view.View
import martakonik.flashcards.Database
import martakonik.flashcards.utils.Navigator

class FlashcardsListViewModel(
        @get: Bindable
        val adapter: WordsListAdapter?,
        database: Database,
        private val boxId: Int,
        @get: Bindable
        val decoration: DividerItemDecoration,
        private val navigator: Navigator) : BaseObservable() {

    @get: Bindable
    val boxName = database.getBox(boxId)?.name ?: ""

    fun onAddClick(view: View) {
        navigator.openAddFlashcardActivity(boxId)
    }
}