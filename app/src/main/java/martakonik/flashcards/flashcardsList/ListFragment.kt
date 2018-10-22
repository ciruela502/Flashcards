package martakonik.flashcards.flashcardsList

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import martakonik.flashcards.BaseFragment
import martakonik.flashcards.databinding.FragmentListBinding
import martakonik.flashcards.services.MockedBoxService

class ListFragment : BaseFragment() {
    private lateinit var binding: FragmentListBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val boxService = MockedBoxService(database)
        val flashcards = boxService.box?.partOfBoxes?.get(0)?.flashcards

        binding.flashcardList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = WordsListAdapter(flashcards)
        }
        binding.viewModel = ListModelView()
    }
}