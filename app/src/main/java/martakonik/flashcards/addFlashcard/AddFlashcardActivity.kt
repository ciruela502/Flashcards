package martakonik.flashcards.addFlashcard

import android.databinding.DataBindingUtil
import android.os.Bundle
import martakonik.flashcards.BaseActivity
import martakonik.flashcards.R
import martakonik.flashcards.databinding.ActivityAddFlashcardBinding
import martakonik.flashcards.utils.SnackbarHelper

class AddFlashcardActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityAddFlashcardBinding>(this, R.layout.activity_add_flashcard)
        val adapter = AddFlashcardAdapter(supportFragmentManager)
        binding.addViewPager.adapter = adapter
        binding.viewModel = AddFlashCardActivityViewModel(database, SnackbarHelper(binding.root), adapter)
        binding.dots.setupWithViewPager(binding.addViewPager)

    }
}