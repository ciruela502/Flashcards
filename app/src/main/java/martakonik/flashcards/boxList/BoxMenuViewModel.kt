package martakonik.flashcards.boxList

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.support.constraint.ConstraintLayout
import android.support.design.widget.BottomSheetBehavior
import android.view.View
import martakonik.flashcards.BR
import martakonik.flashcards.Database
import martakonik.flashcards.data.notEmpty
import martakonik.flashcards.utils.Navigator

class BoxMenuViewModel(
        private val navigator: Navigator?,
        private val sheetBehavior: BottomSheetBehavior<ConstraintLayout?>,
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
        sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    fun onShowFlashcardsClick(view: View) {
        navigator?.openFlashcardListActivity(boxId)
        sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    fun onAddFlashcardsClick(view: View) {
        navigator?.openAddFlashcardActivity(boxId)
        sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    fun outsideClick(view: View) {
        sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }
}
