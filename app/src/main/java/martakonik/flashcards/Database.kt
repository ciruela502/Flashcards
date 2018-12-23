package martakonik.flashcards

import io.reactivex.Flowable
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmModel
import io.realm.RealmResults
import martakonik.flashcards.data.Box
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
        return realm.where(Flashcard::class.java).equalTo("boxId", boxId).sort("partOfBoxId").findAll()
    }

    fun getBoxList(): Flowable<RealmResults<Box>> {
        return realm.where(Box::class.java).findAll().asFlowable()
    }

    fun <T : RealmModel> getCopiedObject(realmObject: T?): T? {
        return realm.copyFromRealm(realmObject)
    }
    fun <T : RealmModel> getCopiedObject(realmObject: Iterable<T>?): MutableList<T>? {
        return realm.copyFromRealm(realmObject)
    }
    fun <T : RealmModel> copyToRealmOrUpdate(objects: Iterable<T>) {
            realm.executeTransaction {
                it.copyToRealmOrUpdate(objects)
            }
    }

    fun updateBoxService(boxService: BoxService?, copiedBoxService: Box) {
        realm.executeTransaction {
            boxService?.box = it.copyToRealmOrUpdate(copiedBoxService)
            it.copyToRealmOrUpdate(boxService?.box)
        }
    }

    fun addFlashcard(flashcard: Flashcard, boxId: Int) {
        realm.executeTransaction { realm ->
            val box = getBox(boxId)

            flashcard.id = getNextFlashcardId(realm)
            box?.let {
                //todo add to current part not first?
                it.partOfBoxes[0]?.flashcards?.add(flashcard)
                realm.copyToRealmOrUpdate(box)
            }
        }
    }

    fun editFlashcard(flashcard: Flashcard) {
        realm.executeTransaction { realm ->
                realm.copyToRealmOrUpdate(flashcard)
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

    fun getFlashcard(flashcardId: Int): Flashcard? {
        return realm.where(Flashcard::class.java).equalTo("id", flashcardId).findFirst()
    }

    fun deleteFlashcard(flashcardId: Int) {
        realm.executeTransaction {
            val flashcard = realm.where(Flashcard::class.java).equalTo("id", flashcardId).findFirst()
            flashcard?.deleteFromRealm()
        }
    }

    fun increasePartOfBox(arg: Flashcard, i: Int) {
        realm.executeTransaction {
            arg.partOfBoxId = i
        }
    }

    fun updateFlashcard(flashcard: Flashcard?, state: Boolean) {
        realm.executeTransaction {
            flashcard?.displayInSession = state
            realm.copyToRealmOrUpdate(flashcard)
        }
    }

    fun updateBoxWithCurrentLearning(box: Box?, list: RealmList<Flashcard>) {
        realm.executeTransaction {
            box?.currentLearning = list
            realm.copyToRealmOrUpdate(box)
        }
    }

    fun clearSession(currentLearning: RealmList<Flashcard>) {
        realm.executeTransaction {
            for (flashcard in currentLearning) {
                flashcard.displayInSession = false
            }
        }
    }

    fun addFlashcardToSession(box: Box?, randomFlashcard: Flashcard) {
        realm.executeTransaction {
            box?.currentLearning?.add(randomFlashcard)
            realm.copyToRealmOrUpdate(box)
        }
    }

    fun removeFromList(currentLearning: RealmList<Flashcard>?, flashcard: Flashcard) {
        realm.executeTransaction {
            currentLearning?.remove(flashcard)
        }
    }
}