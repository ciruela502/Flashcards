package martakonik.flashcards

import io.realm.Realm
import io.realm.RealmModel
import martakonik.flashcards.data.Box
import martakonik.flashcards.models.Flashcard
import martakonik.flashcards.services.BoxService
import martakonik.flashcards.services.MockedBoxService

class Database(private val realm: Realm) {

    fun getFlashcards(): Box? {
        return realm.where(Box::class.java).findFirst()
    }

    fun saveFlashcards(box: Box) {
        realm.executeTransaction {
            it.copyToRealmOrUpdate(box)
        }
    }

    fun <T: RealmModel> getCopiedObject(realmObject: T?): T? {
        return realm.copyFromRealm(realmObject)
    }

    fun updateBoxService(boxService: BoxService?, copiedBoxService: Box) {
        realm.executeTransaction {
            boxService?.box = it.copyToRealmOrUpdate(copiedBoxService)
            it.copyToRealmOrUpdate(boxService?.box)
        }
    }

    fun addFlashcard(flashcard: Flashcard) {
        realm.executeTransaction {realm ->
            //todo change when add more boxes
            val box = realm.where(Box::class.java).findFirst()

            val num = realm.where(Flashcard::class.java).max("id")
            val nextID: Int
            nextID = if (num == null) {
                1
            } else {
                num.toInt() + 1
            }
            flashcard.id = nextID
            box?.let {
                it.partOfBoxes[0]?.flashcards?.add(flashcard)
                realm.copyToRealmOrUpdate(box)
            }
//            val obj = realm.createObject(Flashcard::class.java, nextID)

        }
    }
}