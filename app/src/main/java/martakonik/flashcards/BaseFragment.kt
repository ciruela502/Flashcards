package martakonik.flashcards

import android.content.Context
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.realm.Realm

open class BaseFragment : Fragment() {

    lateinit var database: Database

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        database = Database(Realm.getDefaultInstance())

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

    }
}
