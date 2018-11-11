package martakonik.flashcards.boxList

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.support.constraint.ConstraintLayout
import android.support.design.widget.BottomSheetBehavior
import martakonik.flashcards.utils.Navigator

class BoxListViewModel(
        @get: Bindable
        val adapter: BoxListAdapter?,
        navigator: Navigator?,
        sheetBehavior: BottomSheetBehavior<ConstraintLayout?>
) : BaseObservable() {
    private val choosenBox = { number: Int -> boxMenuViewModel.updateBox(number) }

    init {
        adapter?.choosenBox = choosenBox
    }

    @get: Bindable
    val boxMenuViewModel = BoxMenuViewModel(navigator, sheetBehavior)
}