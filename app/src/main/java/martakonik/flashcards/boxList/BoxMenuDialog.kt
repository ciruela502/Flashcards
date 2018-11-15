package martakonik.flashcards.boxList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import martakonik.flashcards.databinding.ViewBottomBoxMenuBinding
import martakonik.flashcards.utils.BOX_ID
import martakonik.flashcards.utils.BaseBottomSheetDialogFragment

class BoxMenuDialog : BaseBottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = ViewBottomBoxMenuBinding.inflate(inflater, container, false)
        val boxId = arguments?.getInt(BOX_ID)
        val viewModel = boxId?.let { BoxMenuViewModel(navigator, database, it, this) }
        binding.viewModel = viewModel
        return binding.root
    }
}