package martakonik.flashcards.addFlashcard

import android.databinding.DataBindingUtil
import android.os.Bundle
import martakonik.flashcards.BaseActivity
import martakonik.flashcards.R
import martakonik.flashcards.databinding.ActivityAddFlashcardBinding
import martakonik.flashcards.utils.BOX_ID
import martakonik.flashcards.utils.SnackbarHelper

class AddFlashcardActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityAddFlashcardBinding>(this, R.layout.activity_add_flashcard)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = AddFlashcardAdapter(supportFragmentManager)
        val boxId = intent.getIntExtra(BOX_ID, 0)
        binding.addViewPager.adapter = adapter
        binding.viewModel = AddFlashCardActivityViewModel(database, SnackbarHelper(binding.root), adapter, boxId)
        binding.dots.setupWithViewPager(binding.addViewPager)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}