package martakonik.flashcards.mainScreen

import android.app.AlertDialog
import android.content.Context
import android.content.res.Resources
import android.view.View
import android.widget.EditText
import martakonik.flashcards.Database
import martakonik.flashcards.R
import martakonik.flashcards.data.Box


class MainViewModel(
        private val context: Context,
        private val database: Database,
        private val resources: Resources
) {

    //todo extract to DialogManager
    fun onAddClick(view: View) {
        val alert = AlertDialog.Builder(context)
        val edittext = EditText(context)
        edittext.hint = resources.getString(R.string.dialog_hint)
        alert.setTitle(resources.getString(R.string.dialog_title))

        alert.setView(edittext)
        alert.setCancelable(true)
        alert.setPositiveButton(resources.getString(R.string.save)) { _, _ ->
            val boxName = edittext.text.toString()
            val box = Box().apply {
                name = boxName
            }
            database.addBox(box)
        }
        alert.show()
    }
}