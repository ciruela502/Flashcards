package martakonik.flashcards


import martakonik.flashcards.data.Box
import martakonik.flashcards.models.Flashcard
import martakonik.flashcards.services.MockedBoxService

class DecreaseStudyLevelUseCase(
        private val boxService: MockedBoxService,
        private val database: Database
) : UseCase<Flashcard, Void> {

    override fun execute(arg: Flashcard): Void? {
        var i = 1 // do not remove if it is first box
        var boxNum = 0

        val copiedBox: Box? = database.getCopiedObject(boxService?.box)
        val partOfBoxes = copiedBox?.partOfBoxes
        partOfBoxes?.let {

            while (i < partOfBoxes.size) {
                val partOfBox = partOfBoxes[i]
                val flashcards = partOfBox?.flashcards
                flashcards?.let {
                    if (!flashcards.isEmpty()) {
                        for (flashcard in flashcards) {
                            if (flashcard == arg) {
                                flashcards.remove(flashcard)
                                boxNum = i
                                break
                            }
                        }
                    }
                }
                i++
            }
            if (boxNum > 0) {
                copiedBox.partOfBoxes?.get(--boxNum)?.flashcards?.add(arg)
            }

            database.updateBoxService(boxService, copiedBox)

        }
        return null
    }
}
