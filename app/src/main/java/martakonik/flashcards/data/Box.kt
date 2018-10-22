package martakonik.flashcards.data

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Box : RealmObject() {
    @PrimaryKey
    var id: Int? = null
    var partOfBoxes: RealmList<PartOfBox> = RealmList()


}
