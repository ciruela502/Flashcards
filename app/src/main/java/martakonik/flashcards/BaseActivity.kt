package martakonik.flashcards

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.realm.Realm
import martakonik.flashcards.utils.Navigator

open class BaseActivity : AppCompatActivity() {

    lateinit var database: Database
    lateinit var navigator: Navigator
    val compositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        database = Database(Realm.getDefaultInstance())
        navigator = Navigator(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}