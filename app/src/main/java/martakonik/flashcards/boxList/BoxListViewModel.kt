package martakonik.flashcards.boxList

import android.databinding.BaseObservable
import android.databinding.Bindable
import martakonik.flashcards.Database
import martakonik.flashcards.flashcardsList.FlashcardsListViewModel

class BoxListViewModel(database: Database) : BaseObservable() {

    @get: Bindable
    val flascardsListViewModel  = FlashcardsListViewModel(database)
}