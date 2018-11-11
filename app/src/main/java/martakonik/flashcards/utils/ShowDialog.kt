package martakonik.flashcards.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

class ShowDialog(private val context: Context?) {

    fun show(titleRes: Int, messageRes: Int, positiveRes: Int, finishCurrentActivity: () -> Unit?) {
        val alert = AlertDialog.Builder(context)
        alert.setTitle(context?.getString(titleRes))
        alert.setMessage(context?.getString(messageRes))
        alert.setCancelable(true)
        alert.setPositiveButton(context?.getString(positiveRes)) { dialogInterface: DialogInterface?, _: Int ->
            dialogInterface?.cancel()
            finishCurrentActivity()
        }
        alert.show()
    }
}