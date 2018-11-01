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
        private val sheetBehavior: BottomSheetBehavior<ConstraintLayout?>?,
        private val choosenBox: (Int) -> Any
) : BaseObservable() {
    @get: Bindable
    val boxName = box.name

    fun onBoxClick(view: View) {
        //show fragment with chosen box
        box.id?.let { choosenBox(it) }
        sheetBehavior?.state = BottomSheetBehavior.STATE_EXPANDED
    }
}