package martakonik.flashcards.boxList

import android.view.View
import martakonik.flashcards.utils.Navigator

class BoxMenuViewModel(
        private val navigator: Navigator?) {

    var boxId: Int = 0

    fun updateBox(boxId: Int) {
        this.boxId = boxId
    }

    fun onLearningClick(view: View) {
        navigator?.openLearningActivity(boxId)
    }

    fun onShowFlashcardsClick(view: View) {
        navigator?.openFlashcardListActivity(boxId)
    }

    fun onAddFlashcardsClick(view: View) {
        navigator?.openAddFlashcardActivity(boxId)
    }
}