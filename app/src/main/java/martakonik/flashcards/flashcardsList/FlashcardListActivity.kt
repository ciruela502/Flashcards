package martakonik.flashcards.flashcardsList

import android.databinding.DataBindingUtil
import android.os.Bundle
import martakonik.flashcards.BaseActivity
import martakonik.flashcards.R
import martakonik.flashcards.databinding.ActivityFlashcardsListBinding
import android.support.v7.widget.DividerItemDecoration
import android.view.Menu
import android.view.MenuItem
import martakonik.flashcards.utils.BOX_ID
import martakonik.flashcards.utils.SnackbarHelper


class FlashcardListActivity : BaseActivity() {
    private lateinit var viewModel: FlashcardsListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityFlashcardsListBinding>(this, R.layout.activity_flashcards_list)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val boxId = intent.getIntExtra(BOX_ID, 0)
        val adapter = database.getFlashcardsListByBoxId(boxId)?.let { WordsListAdapter(it, supportFragmentManager, resources) }
        val decoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
        viewModel = FlashcardsListViewModel(adapter, database, boxId, decoration, navigator, SnackbarHelper(binding.root))
        binding.viewModel = viewModel
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_delete, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_delete -> {
            viewModel.deleteBox()
            true
        } else -> false
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}