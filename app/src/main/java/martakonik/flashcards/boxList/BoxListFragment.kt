package martakonik.flashcards.boxList

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.rxkotlin.addTo
import martakonik.flashcards.BaseFragment
import martakonik.flashcards.databinding.FragmentBoxListBinding
import martakonik.flashcards.utils.BottomMenuManager

class BoxListFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentBoxListBinding.inflate(inflater, container, false)
        val bottomMenu = BottomMenuManager(BottomSheetBehavior.from(binding.flashcardList?.bottomsheet))
        database.getBoxList().subscribe {
            val adapter = BoxListAdapter(it, bottomMenu)
            binding.viewModel = BoxListViewModel(adapter, navigator, bottomMenu, database)
        }.addTo(compositeDisposable)

        return binding.root
    }
}