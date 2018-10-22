package martakonik.flashcards.data

import io.realm.RealmList
import io.realm.RealmObject
import java.util.ArrayList

import martakonik.flashcards.models.Flashcard

open class PartOfBox : RealmObject {
    var flashcards: RealmList<Flashcard> = RealmList()
    var id: Int = 0

    constructor(flashcards: RealmList<Flashcard>, id: Int) {
        this.flashcards = flashcards
        this.id = id
    }

    constructor(id: Int) {
        this.id = id
    }

    constructor()
}
