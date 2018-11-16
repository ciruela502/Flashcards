package martakonik.flashcards.data

import io.realm.RealmList
import io.realm.RealmObject
import martakonik.flashcards.R
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

fun Int?.getTitle(): Int {
    return when (this) {
        0 -> R.string.part0
        1 -> R.string.part1
        2 -> R.string.part2
        3 -> R.string.part3
        else -> R.string.part4
    }
}
