package martakonik.flashcards.boxList

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import martakonik.flashcards.BaseFragment
import martakonik.flashcards.databinding.FragmentBoxListBinding

class BoxListFragment : BaseFragment() {

    private lateinit var binding: FragmentBoxListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBoxListBinding.inflate(inflater, container, false)
        //todo change this to manager
        val sheetBehavior = BottomSheetBehavior.from(binding.flashcardList?.bottomsheet)
        val adapter = database.getBoxList()?.let { BoxListAdapter(it, sheetBehavior) }
        binding.viewModel = BoxListViewModel(adapter, navigator, sheetBehavior)

        return binding.root
    }
}