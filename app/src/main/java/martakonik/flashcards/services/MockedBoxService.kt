package martakonik.flashcards.services

import io.realm.RealmList
import martakonik.flashcards.Database

import martakonik.flashcards.models.Flashcard
import martakonik.flashcards.data.Box
import martakonik.flashcards.data.PartOfBox

class MockedBoxService(private val database: Database) : BoxService {

    override var box: Box? = getBoxFromDatabase()

    fun getBoxFromDatabase(): Box? {
//        saveBox()
        return database.getFlashcards()
    }

    fun saveBox() {
        database.saveFlashcards(getMockedBox(1, 1, "first"))
        database.saveFlashcards(getMockedBox(2, 10, "second"))
    }

    private fun getMockedBox(boxId: Int, id: Int, s: String): Box {
        val box = Box().apply {
            this.id = boxId
            this.name = s
        }

        val flashcards = RealmList<Flashcard>()
        flashcards.add(Flashcard("word1", "slowo1", id+1, boxId))
        flashcards.add(Flashcard("word2", "slowo2", id+2, boxId))
        flashcards.add(Flashcard("word3", "slowo3", id+3, boxId))
        flashcards.add(Flashcard("word4", "slowo4", id+4, boxId))
        flashcards.add(Flashcard("word5", "slowo5", id+5, boxId))

        box.partOfBoxes.add(PartOfBox(flashcards, 1))
        box.partOfBoxes.add(PartOfBox(2))
        box.partOfBoxes.add(PartOfBox(3))
        box.partOfBoxes.add(PartOfBox(4))
        box.partOfBoxes.add(PartOfBox(5))

        return box
    }


}
