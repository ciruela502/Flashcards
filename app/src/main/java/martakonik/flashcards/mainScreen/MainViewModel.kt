package martakonik.flashcards.mainScreen

import android.view.View
import martakonik.flashcards.utils.Navigator

class MainViewModel(private val navigator: Navigator) {

    fun onAddClick(view: View) {
        navigator.openAddFlashcardActivity()
    }
}