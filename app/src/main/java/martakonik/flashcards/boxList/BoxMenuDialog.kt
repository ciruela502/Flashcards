package martakonik.flashcards.boxList

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.disposables.CompositeDisposable
import io.realm.Realm
import martakonik.flashcards.Database
import martakonik.flashcards.databinding.ViewBottomBoxMenuBinding
import martakonik.flashcards.utils.BOX_ID
import martakonik.flashcards.utils.Navigator

class BoxMenuDialog : BottomSheetDialogFragment() {
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = ViewBottomBoxMenuBinding.inflate(inflater, container, false)
        val boxId = arguments?.getInt(BOX_ID)
        val viewModel = boxId?.let { BoxMenuViewModel(navigator, database, it, this) }
        binding.viewModel = viewModel
        return binding.root
    }
}