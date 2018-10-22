package martakonik.flashcards

import android.app.Application
import io.realm.Realm


class GlobalApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
//        val realmConfig = RealmConfiguration.Builder()
//                .schemaVersion(16)
//                .migration(RealmMigrationHelper())
//                .deleteRealmIfMigrationNeeded()
//                .rxFactory(RealmObservableFactory())
//                .build()
//        Realm.setDefaultConfiguration(realmConfig)
    }
}