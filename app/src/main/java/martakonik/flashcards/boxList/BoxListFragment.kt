package martakonik.flashcards.boxList

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import martakonik.flashcards.BaseFragment
import martakonik.flashcards.databinding.FragmentBoxListBinding

class BoxListFragment : BaseFragment() {

    private lateinit var binding: FragmentBoxListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBoxListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sheetBehavior = BottomSheetBehavior.from(binding.flashcardList?.bottomsheet)

        binding.flashcardBoxList.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = database.getBoxList()?.let { BoxListAdapter(it, sheetBehavior) }
        }
        binding.viewModel = BoxListViewModel(database)
    }
}