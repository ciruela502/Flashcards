package martakonik.flashcards

import martakonik.flashcards.models.Flashcard
import martakonik.flashcards.services.BoxService


class GetNextCardUseCase(var boxService: BoxService) : UseCase<Void, Flashcard> {

    var previousCardId = -1

    override fun execute(arg: Void?): Flashcard? {
        val box = boxService.box
        val partOfBoxes = box?.partOfBoxes
        partOfBoxes?.let {
            for (part in partOfBoxes) {
                if (!part.flashcards.isEmpty()) {
                    //todo introduce learning session
                    //get next card, randomize it or flag if it was show in this learning session
                    for (flashcard in part.flashcards) {
                        if (previousCardId != flashcard.id) {
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
