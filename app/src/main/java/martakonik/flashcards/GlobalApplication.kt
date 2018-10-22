package martakonik.flashcards

import android.app.Application
import io.realm.Realm


class GlobalApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
    }
}