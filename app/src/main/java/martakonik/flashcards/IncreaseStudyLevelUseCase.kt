package martakonik.flashcards


import martakonik.flashcards.data.Box
import martakonik.flashcards.models.Flashcard
import martakonik.flashcards.services.BoxService

class IncreaseStudyLevelUseCase(private var boxService: BoxService?,
                                private var database: Database) : UseCase<Flashcard, Void> {

    override fun execute(arg: Flashcard): Void? {
        var i = 0
        var partOfBoxNum = 0

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
                                if (i < partOfBoxes.size - 1) {
                                    flashcards.remove(flashcard)
                                    flashcard.partOfBoxId = flashcard.partOfBoxId + 1
                                } else {
                                    flashcard.learnt = true
                                    copiedBox.currentLearning.remove(flashcard)
                                    flashcard.partOfBoxId = 4
                                }
                                partOfBoxNum = i
                                break
                            }
                        }
                    }
                }
                i++
            }

            if (partOfBoxNum < partOfBoxes.size - 1) {
                val newPart = ++partOfBoxNum
                copiedBox.partOfBoxes.get(newPart)?.flashcards?.add(arg)
            }

            database.updateBoxService(boxService, copiedBox)
        }
        return null
    }
}
