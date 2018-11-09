package martakonik.flashcards.learning

import android.databinding.BaseObservable
import android.databinding.Bindable
import martakonik.flashcards.Database

class LearningActivityViewModel(database: Database, boxId: Int) : BaseObservable() {

    @get: Bindable
    val boxName = database.getBox(boxId)?.name ?: ""
}