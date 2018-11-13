package martakonik.flashcards.mainScreen

import android.app.Activity
import android.app.AlertDialog
import martakonik.flashcards.Database
import martakonik.flashcards.R
import martakonik.flashcards.data.Box


class AddBoxDialog(
        private val context: Activity,
        private val database: Database) {

    fun show() {
        val alert = AlertDialog.Builder(context)
        val inflater = context.layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_add_box, null)
        alert.setView(dialogView)

        val editText = dialogView.findViewById(R.id.newBoxName) as android.support.design.widget.TextInputEditText
        alert.setCancelable(true)
        alert.setPositiveButton(context.getString(R.string.add)) { _, _ ->
            val boxName = editText.text.toString()
            val box = Box().apply {
                name = boxName
            }
            database.addBox(box)
        }
        alert.show()
    }
}