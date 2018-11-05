package martakonik.flashcards.flashcardsList

import android.databinding.DataBindingUtil
import android.os.Bundle
import martakonik.flashcards.BaseActivity
import martakonik.flashcards.R
import martakonik.flashcards.databinding.ActivityFlashcardsListBinding
import martakonik.flashcards.learning.BOX_ID

class FlashcardListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityFlashcardsListBinding>(this, R.layout.activity_flashcards_list)
        val boxId = intent.getIntExtra(BOX_ID, 0)
        val adapter = database.getFlashcardsListByBoxId(boxId)?.let { WordsListAdapter(it) }

        binding.viewModel = FlashcardsListViewModel(adapter)
    }
}