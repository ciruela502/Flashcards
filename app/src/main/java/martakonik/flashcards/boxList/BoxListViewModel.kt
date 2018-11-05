package martakonik.flashcards.boxList

import android.databinding.BaseObservable
import android.databinding.Bindable
import martakonik.flashcards.utils.Navigator

class BoxListViewModel(
        @get: Bindable
        val adapter: BoxListAdapter?,
        navigator: Navigator?
) : BaseObservable() {
    private val choosenBox = { number: Int -> boxMenuViewModel.updateBox(number) }

    init {
        adapter?.choosenBox = choosenBox
    }

    @get: Bindable
    val boxMenuViewModel = BoxMenuViewModel(navigator)
}