package martakonik.flashcards.data

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Box : RealmObject() {
    @PrimaryKey
    var id: Int? = null
    var name: String = ""
    var partOfBoxes: RealmList<PartOfBox> = RealmList()
}
fun Box?.notEmpty(): Boolean {
    this?.partOfBoxes?.forEach {
        if (it.flashcards.isNotEmpty() )
            return true
    }
    return false
}
