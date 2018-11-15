package martakonik.flashcards.utils

import android.content.Context
import android.support.design.widget.BottomSheetDialogFragment
import io.reactivex.disposables.CompositeDisposable
import io.realm.Realm
import martakonik.flashcards.Database
import martakonik.flashcards.boxList.BoxMenuViewModel

open class BaseBottomSheetDialogFragment : BottomSheetDialogFragment() {
    lateinit var database: Database
    lateinit var viewModel: BoxMenuViewModel
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