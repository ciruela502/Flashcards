package martakonik.flashcards

import io.realm.RealmList
import martakonik.flashcards.data.Box
import martakonik.flashcards.models.Flashcard
import martakonik.flashcards.services.BoxService
import java.util.*


class GetNextCardUseCase(private val database: Database,
                         private val boxService: BoxService,
                         private val finishSession: () -> Unit,
                         private val finish: () -> Unit) : UseCase<Void, Flashcard> {

    var boxLearnt = false
    var count = 3

    override fun execute(arg: Void?): Flashcard? {

        val currentLearning = boxService.box?.currentLearning
        val filter = currentLearning?.filter { it.learnt }
        filter?.forEach {
            database.removeFromList(currentLearning, it)
        }
        currentLearning?.let {
            if (currentLearning.isEmpty()) {
                database.updateBoxWithCurrentLearning(boxService.box, getRandomFlashcards(boxService.box))
            }
            if (currentLearning.size < count) {
                val randomFlashcard = getRandomFlashcard(boxService.box)
                if (randomFlashcard != null) {
                    database.addFlashcardToSession(boxService.box, randomFlashcard)
                }
            }
            for (flashcard in it)
                if (!flashcard.displayInSession) {
                    if (flashcard.learnt && !boxLearnt) {
                        boxLearnt = true
                        finish()
                    }
                    database.updateFlashcardDisplayInSession(flashcard, true)
                    return flashcard
                }
        }
        finishSession()
        currentLearning?.let { database.clearSession(it) }
        return null
    }

    private fun getRandomFlashcards(box: Box?): RealmList<Flashcard> {
        val notStartedFlashcards = box?.partOfBoxes?.get(0)?.flashcards
        notStartedFlashcards?.let {
            val minOf = minOf(notStartedFlashcards.size, count)
            return notStartedFlashcards.random(Random(), minOf)
        }
        return RealmList()
    }

    private fun getRandomFlashcard(box: Box?): Flashcard? {
        val notStartedFlashcards = box?.partOfBoxes?.get(0)?.flashcards
        notStartedFlashcards?.let {
            if (notStartedFlashcards.size > 0) {
                return it[Random().nextInt(it.size)]
            }
        }
        return null
    }
}

private fun RealmList<Flashcard>.random(random: Random, count: Int): RealmList<Flashcard> {

    var list = RealmList<Flashcard>()
    for (i in 1..count) {
        while (!addNewFlashcard(random, list)) {
        }
    }
    return list
}

private fun RealmList<Flashcard>.addNewFlashcard(random: Random, list: RealmList<Flashcard>): Boolean {
    val flashcard = get(random.nextInt(size))
    if (!list.contains(flashcard)) {
        list.add(flashcard)
        return true
    }
    return false
}
