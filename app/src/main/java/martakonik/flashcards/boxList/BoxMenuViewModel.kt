package martakonik.flashcards.boxList

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import martakonik.flashcards.Database
import martakonik.flashcards.data.notEmpty
import martakonik.flashcards.utils.Navigator

class BoxMenuViewModel(
        private val navigator: Navigator?,
        private val database: Database,
        @Bindable
        var boxId: Int,
        private val boxMenuDialog: BoxMenuDialog) : BaseObservable() {

    @get: Bindable
    val boxName = database.getBox(boxId)?.name ?: ""

            @get: Bindable("boxId")
    var flashcardOptionVisible = false
        get() = database.getBox(boxId).notEmpty()

    fun onLearningClick(view: View) {
        navigator?.openLearningActivity(boxId)
        boxMenuDialog.dismiss()
    }

    fun onShowFlashcardsClick(view: View) {
        navigator?.openFlashcardListActivity(boxId)
        boxMenuDialog.dismiss()
    }

    fun onAddFlashcardsClick(view: View) {
        navigator?.openAddFlashcardActivity(boxId)
        boxMenuDialog.dismiss()
    }

    fun outsideClick(view: View) {
        boxMenuDialog.dismiss()
    }
}
