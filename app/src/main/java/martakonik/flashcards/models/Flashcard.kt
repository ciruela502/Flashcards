package martakonik.flashcards.models

import android.os.Parcelable
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
open class Flashcard() : RealmObject(), Parcelable {
    @PrimaryKey
    var id: Int = 0
    var word = ""
    var translation = ""

    constructor(word: String, translation: String, id: Int) : this() {
        this.word = word
        this.translation = translation
        this.id = id
    }

    override fun equals(obj: Any?): Boolean {
        return obj is Flashcard && obj.id == this.id
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + word.hashCode()
        result = 31 * result + translation.hashCode()
        return result
    }
}
