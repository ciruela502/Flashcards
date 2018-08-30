package martakonik.flashcards.services

import java.util.ArrayList

import martakonik.fiszki.domain.models.Flashcard
import martakonik.flashcards.data.Box
import martakonik.flashcards.data.PartOfBox

class MockedBoxService : BoxService {
    private var box: Box = getBox()

    override fun getBox(): Box {
        val box = Box()

        val flashcards = ArrayList<Flashcard>()
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
