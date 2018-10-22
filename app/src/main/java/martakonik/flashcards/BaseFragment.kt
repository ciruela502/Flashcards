package martakonik.flashcards

import android.content.Context
import android.support.v4.app.Fragment
import io.realm.Realm

open class BaseFragment : Fragment() {

    lateinit var database: Database

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        database = Database(Realm.getDefaultInstance())
    }
}
