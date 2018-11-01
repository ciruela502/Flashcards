package martakonik.flashcards.boxList

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.support.constraint.ConstraintLayout
import android.support.design.widget.BottomSheetBehavior
import android.view.View
import martakonik.flashcards.data.Box

class BoxItemViewModel(
        @get: Bindable
        val box: Box,
        private val sheetBehavior: BottomSheetBehavior<ConstraintLayout?>?
) : BaseObservable() {
    @get: Bindable
    val boxName = box.name

    fun onBoxClick(view: View) {
        sheetBehavior?.state = BottomSheetBehavior.STATE_EXPANDED
    }
}