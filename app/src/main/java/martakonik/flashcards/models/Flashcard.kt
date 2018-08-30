package martakonik.fiszki.domain.models

import java.io.Serializable

class Flashcard : Serializable {
    private var id: Int = 0
    var word = ""
    var translation = ""

    constructor() {}

    constructor(word: String, translation: String, id: Int) {
        this.word = word
        this.translation = translation
        this.id = id
    }

    override fun equals(obj: Any?): Boolean {
        return obj is Flashcard && obj.id == this.id
    }
}
