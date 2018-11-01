package martakonik.flashcards.boxList

import android.databinding.BaseObservable
import android.databinding.Bindable
import martakonik.flashcards.Database
import martakonik.flashcards.flashcardsList.FlashcardsListViewModel

class BoxListViewModel(
        database: Database,
        @get: Bindable
        val adapter: BoxListAdapter?
) : BaseObservable() {
    private val choosenBox = { number: Int -> flascardsListViewModel.updateBox(number) }

    init {
        adapter?.choosenBox = choosenBox
    }

    @get: Bindable
    val flascardsListViewModel = FlashcardsListViewModel(database)
}