package martakonik.flashcards.mainScreen

import android.app.AlertDialog
import android.content.Context
import android.view.View
import android.widget.EditText
import martakonik.flashcards.Database
import martakonik.flashcards.data.Box


class MainViewModel(
        private val context: Context,
        private val database: Database
) {

    //todo extract to DialogManager
    fun onAddClick(view: View) {
        val alert = AlertDialog.Builder(context)
        val edittext = EditText(context)
        edittext.hint = "Enter new box name"
        alert.setTitle("Add new box")

        alert.setView(edittext)

        alert.setPositiveButton("Save") { _, _ ->
            val boxName = edittext.text.toString()
            val box = Box().apply {
                name = boxName
            }
            database.addBox(box)
        }
        alert.show()
    }
}