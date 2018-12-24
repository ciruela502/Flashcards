package martakonik.flashcards.flashcardsList

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.support.v7.widget.DividerItemDecoration
import android.view.View
import martakonik.flashcards.Database
import martakonik.flashcards.R
import martakonik.flashcards.utils.Navigator
import martakonik.flashcards.utils.SnackbarHelper

class FlashcardsListViewModel(
        @get: Bindable
        val adapter: WordsListAdapter?,
        private val database: Database,
        private val boxId: Int,
        @get: Bindable
        val decoration: DividerItemDecoration,
        private val navigator: Navigator,
        private val snackbarHelper: SnackbarHelper) : BaseObservable() {

    @get: Bindable
    val boxName = database.getBox(boxId)?.name ?: ""

    fun onAddClick(view: View) {
        navigator.openAddFlashcardActivity(boxId)
    }

    fun deleteBox(): Boolean {
        database.deleteBox(boxId)
        snackbarHelper.showSnackbar(R.string.box_deleted)
        navigator.finishCurrentActivity()
        return true
    }

}