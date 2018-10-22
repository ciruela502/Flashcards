package martakonik.flashcards

import io.realm.Realm
import io.realm.RealmModel
import martakonik.flashcards.data.Box
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
}