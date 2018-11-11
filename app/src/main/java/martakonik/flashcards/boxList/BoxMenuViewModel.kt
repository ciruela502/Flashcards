package martakonik.flashcards.boxList

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import martakonik.flashcards.BR
import martakonik.flashcards.Database
import martakonik.flashcards.data.notEmpty
import martakonik.flashcards.utils.BottomMenuManager
import martakonik.flashcards.utils.Navigator

class BoxMenuViewModel(
        private val navigator: Navigator?,
        private val bottomMenu: BottomMenuManager,
        private val database: Database) : BaseObservable() {

    @Bindable
    var boxId: Int = 0

    @get: Bindable("boxId")
    var flashcardOptionVisible = false
        get() = database.getBox(boxId).notEmpty()

    fun updateBox(boxId: Int) {
        this.boxId = boxId
        notifyPropertyChanged(BR.boxId)
    }

    fun onLearningClick(view: View) {
        navigator?.openLearningActivity(boxId)
        bottomMenu.hide()
    }

    fun onShowFlashcardsClick(view: View) {
        navigator?.openFlashcardListActivity(boxId)
        bottomMenu.hide()
    }

    fun onAddFlashcardsClick(view: View) {
        navigator?.openAddFlashcardActivity(boxId)
        bottomMenu.hide()
    }

    fun outsideClick(view: View) {
        bottomMenu.hide()
    }
}
