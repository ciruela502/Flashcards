package martakonik.flashcards

import martakonik.flashcards.models.Flashcard
import martakonik.flashcards.services.BoxService


class GetNextCardUseCase(
        private val boxService: BoxService,
        private val finish: () -> Unit) : UseCase<Void, Flashcard> {

    var previousCardId = -1
    var boxLearnt = false

    override fun execute(arg: Void?): Flashcard? {
        val box = boxService.box
        val partOfBoxes = box?.partOfBoxes
        partOfBoxes?.let {
            for (part in partOfBoxes) {
                if (!part.flashcards.isEmpty()) {
                    //todo introduce learning session
                    //get next card, randomize it or flag if it was show in this learning session
                    val size = part.flashcards.size
                    for (flashcard in part.flashcards) {
                        if (previousCardId != flashcard.id || size == 1) {
                            if (flashcard.learnt && !boxLearnt) {
                                boxLearnt = true
                                finish()
                            }
                            previousCardId = flashcard.id
                            return flashcard
                        }
                    }
                }
            }
        }
        return null
    }
}
