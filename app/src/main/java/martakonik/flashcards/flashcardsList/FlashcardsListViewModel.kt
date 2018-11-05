package martakonik.flashcards.flashcardsList

import android.databinding.BaseObservable
import android.databinding.Bindable

class FlashcardsListViewModel(
        @get: Bindable
        val adapter: WordsListAdapter?) : BaseObservable()