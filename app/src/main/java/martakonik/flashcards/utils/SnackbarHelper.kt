package martakonik.flashcards.utils

import android.support.design.widget.Snackbar
import android.view.View

class SnackbarHelper(private val view: View) {

    fun showSnackbar(textId: Int) {
        Snackbar.make(view, textId, Snackbar.LENGTH_SHORT).show()
    }
}