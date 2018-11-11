package martakonik.flashcards.mainScreen

import android.app.AlertDialog
import android.content.Context
import android.widget.EditText
import martakonik.flashcards.Database
import martakonik.flashcards.R
import martakonik.flashcards.data.Box

class AddBoxDialog(
        private val context: Context,
        private val database: Database) {

    fun show() {
        val alert = AlertDialog.Builder(context)
        val editText = EditText(context)
        editText.hint = context.getString(R.string.dialog_hint)
        alert.setTitle(context.getString(R.string.dialog_title))

        alert.setView(editText)
        alert.setCancelable(true)
        alert.setPositiveButton(context.getString(R.string.save)) { _, _ ->
            val boxName = editText.text.toString()
            val box = Box().apply {
                name = boxName
            }
            database.addBox(box)
        }
        alert.show()
    }
}