package martakonik.flashcards.learning

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import martakonik.fiszki.domain.models.Flashcard
import martakonik.flashcards.services.MockedBoxService

class LearningViewModel : BaseObservable() {

    @get: Bindable
    var word = ""

    @get: Bindable
    var wordVisibility = View.GONE

    @get: Bindable
    var translation = ""

    @get: Bindable
    var translationVisibility = View.VISIBLE

    init {
        newFlashcard()
    }

    fun newFlashcard() {
        var flascard = getFlascard()
        word = flascard.word
        translation = flascard.translation
        wordVisibility = View.VISIBLE

    }

    fun getFlascard(): Flashcard {
        val box = MockedBoxService().box
        val partOfBoxes = box.partOfBoxes
        // todo change to more sophisticated algorithm
        for (part in partOfBoxes) {
            if (!part.flashcards.isEmpty()) {
                return part.flashcards[0]
            }
        }
        throw IllegalStateException("no more flashcards")
    }
}