package martakonik.flashcards

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.realm.Realm
import martakonik.flashcards.utils.Navigator

open class BaseActivity : AppCompatActivity() {

    lateinit var database: Database
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        database = Database(Realm.getDefaultInstance())
        navigator = Navigator(this)
    }
}