package martakonik.flashcards.utils

import android.support.v4.app.FragmentManager
import martakonik.flashcards.boxList.BoxMenuDialog

class BottomMenuManager(
        private val dialog: BoxMenuDialog,
        private val fragmentManager: FragmentManager?
) {

    var boxId = -1

    fun show() {
        dialog.show(fragmentManager, "tag")
    }

    fun hide() {
        dialog.dismiss()
    }
}