package martakonik.flashcards.services

import io.realm.RealmList
import io.realm.RealmResults
import martakonik.flashcards.Database

import martakonik.flashcards.models.Flashcard
import martakonik.flashcards.data.Box
import martakonik.flashcards.data.PartOfBox

class MockedBoxService(private val database: Database) : BoxService {

    override var box: Box? = getBoxFromDatabase()

    fun getBoxFromDatabase(): Box? {
        return database.getFlashcards()
    }

    fun saveBox() {
        database.saveFlashcards(getMockedBox())
    }

    private fun getMockedBox(): Box {
        val box = Box().apply {
            id = 1
        }

        val flashcards = RealmList<Flashcard>()
        flashcards.add(Flashcard("word1", "slowo1", 1))
        flashcards.add(Flashcard("word2", "slowo2", 2))
        flashcards.add(Flashcard("word3", "slowo3", 3))
        flashcards.add(Flashcard("word4", "slowo4", 4))
        flashcards.add(Flashcard("word5", "slowo5", 5))

        box.partOfBoxes.add(PartOfBox(flashcards, 1))
        box.partOfBoxes.add(PartOfBox(2))
        box.partOfBoxes.add(PartOfBox(3))
        box.partOfBoxes.add(PartOfBox(4))
        box.partOfBoxes.add(PartOfBox(5))

        return box
    }


}
