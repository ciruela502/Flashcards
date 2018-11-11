package martakonik.flashcards

import android.content.Context
import android.support.v4.app.Fragment
import io.reactivex.disposables.CompositeDisposable
import io.realm.Realm
import martakonik.flashcards.utils.Navigator

open class BaseFragment : Fragment() {

    lateinit var database: Database
    var navigator: Navigator? = null
    val compositeDisposable = CompositeDisposable()

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        database = Database(Realm.getDefaultInstance())
        navigator = Navigator(requireActivity())
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
