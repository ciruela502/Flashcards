package martakonik.flashcards.data

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import martakonik.flashcards.models.Flashcard

open class Box : RealmObject() {
    @PrimaryKey
    var id: Int? = null
    var name: String = ""
    var currentLearning = RealmList<Flashcard>()
    var partOfBoxes: RealmList<PartOfBox> = RealmList(PartOfBox(), PartOfBox(), PartOfBox(), PartOfBox(), PartOfBox())
}
fun Box?.notEmpty(): Boolean {
    this?.partOfBoxes?.forEach {
        if (it.flashcards.isNotEmpty() )
            return true
    }
    return false
}
