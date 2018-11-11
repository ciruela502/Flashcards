package martakonik.flashcards.boxList

import android.support.constraint.ConstraintLayout
import android.support.design.widget.BottomSheetBehavior
import android.view.View
import martakonik.flashcards.utils.Navigator

class BoxMenuViewModel(
        private val navigator: Navigator?,
        private val sheetBehavior: BottomSheetBehavior<ConstraintLayout?>) {

    var boxId: Int = 0

    fun updateBox(boxId: Int) {
        this.boxId = boxId
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