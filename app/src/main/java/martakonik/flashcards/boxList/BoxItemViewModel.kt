package martakonik.flashcards.boxList

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import martakonik.flashcards.data.Box
import martakonik.flashcards.utils.BottomMenuManager

class BoxItemViewModel(
        @get: Bindable
        val box: Box,
        private val bottomMenu: BottomMenuManager,
        private val chooseBox: (Int) -> Any
) : BaseObservable() {
    @get: Bindable
    val boxName = box.name

    fun onBoxClick(view: View) {
        box.id?.let { chooseBox(it) }
        bottomMenu.show()
    }
}