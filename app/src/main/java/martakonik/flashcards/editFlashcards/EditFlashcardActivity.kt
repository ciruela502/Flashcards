package martakonik.flashcards.editFlashcards

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import martakonik.flashcards.BaseActivity
import martakonik.flashcards.R
import martakonik.flashcards.addFlashcard.AddFlashcardAdapter
import martakonik.flashcards.databinding.ActivityEditFlashcardBinding
import martakonik.flashcards.utils.SnackbarHelper

const val FLASHCARD_ID = "flashcard_id"

class EditFlashcardActivity : BaseActivity() {

    private lateinit var viewModel: EditFlashcardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val flashcardId = intent.getIntExtra(FLASHCARD_ID, 0)
        val binding = DataBindingUtil.setContentView<ActivityEditFlashcardBinding>(this, R.layout.activity_edit_flashcard)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = AddFlashcardAdapter(supportFragmentManager, flashcardId)
        binding.addViewPager.adapter = adapter
        binding.dots.setupWithViewPager(binding.addViewPager)
        viewModel = EditFlashcardViewModel(database, flashcardId, SnackbarHelper(binding.root), adapter, navigator)
        binding.viewModel = viewModel
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_delete, menu)
        return true
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        R.id.action_delete -> viewModel.deleteFlashcard()
        else -> super.onOptionsItemSelected(item)
    }
}