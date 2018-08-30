package martakonik.flashcards.data

import java.util.ArrayList

import martakonik.fiszki.domain.models.Flashcard

class PartOfBox {
    var flashcards: List<Flashcard> = ArrayList()
    internal var id: Int = 0

    constructor(flashcards: List<Flashcard>, id: Int) {
        this.flashcards = flashcards
        this.id = id
    }

    constructor(id: Int) {
        this.id = id
    }
}
