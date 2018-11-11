package martakonik.flashcards.utils

import android.support.constraint.ConstraintLayout
import android.support.design.widget.BottomSheetBehavior

class BottomMenuManager(private val sheetBehavior: BottomSheetBehavior<ConstraintLayout?>) {

    fun show() {
        sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    fun hide() {
        sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }
}