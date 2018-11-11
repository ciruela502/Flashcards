package martakonik.flashcards

import io.reactivex.Flowable
import io.realm.Realm
import io.realm.RealmModel
import io.realm.RealmResults
import martakonik.flashcards.data.Box
import martakonik.flashcards.data.PartOfBox
import martakonik.flashcards.models.Flashcard
import martakonik.flashcards.services.BoxService

class Database(private val realm: Realm) {

    fun getFlashcards(boxId: Int): Box? {
        return realm.where(Box::class.java).equalTo("id", boxId).findFirst()
    }

    fun saveFlashcards(box: Box) {
        realm.executeTransaction {
            it.copyToRealmOrUpdate(box)
        }
    }

    fun getFlashcardsListByBoxId(boxId: Int): RealmResults<Flashcard>? {
        return realm.where(Flashcard::class.java).equalTo("boxId", boxId).findAll()
    }
    fun getBoxList(): Flowable<RealmResults<Box>> {
        return realm.where(Box::class.java).findAll().asFlowable()
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

    fun addFlashcard(flashcard: Flashcard, boxId: Int) {
        realm.executeTransaction {realm ->
            val box = getBox(boxId)

            flashcard.id = getNextFlashcardId(realm)
            box?.let {
                if (it.partOfBoxes.isEmpty() || it.partOfBoxes[0] == null) {
                    it.partOfBoxes.add(PartOfBox())
                }
                it.partOfBoxes[0]?.flashcards?.add(flashcard)
                realm.copyToRealmOrUpdate(box)
            }
        }
    }

    private fun getNextFlashcardId(realm: Realm): Int {
        val num = realm.where(Flashcard::class.java).max("id")
        val nextId: Int
        nextId = if (num == null) {
            1
        } else {
            num.toInt() + 1
        }
        return nextId
    }

    fun addBox(newBox: Box) {
        realm.executeTransaction {
            newBox.id = getBoxId(realm)
            it.copyToRealmOrUpdate(newBox)
        }
    }

    private fun getBoxId(realm: Realm): Int {
        val num = realm.where(Box::class.java).max("id")
        val nextId: Int
        nextId = if (num == null) {
            1
        } else {
            num.toInt() + 1
        }
        return nextId
    }

    fun getBox(boxId: Int): Box? {
        return realm.where(Box::class.java).equalTo("id", boxId).findFirst()
    }
}