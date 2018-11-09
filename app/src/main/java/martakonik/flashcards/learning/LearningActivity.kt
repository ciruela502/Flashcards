package martakonik.flashcards.learning

import android.databinding.DataBindingUtil
import android.os.Bundle
import martakonik.flashcards.BaseActivity
import martakonik.flashcards.R
import martakonik.flashcards.databinding.ActivityLearningBinding

const val BOX_ID = "box_id"

class LearningActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityLearningBinding>(this, R.layout.activity_learning)
        val boxId = intent.getIntExtra(BOX_ID, 0)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.viewModel = LearningActivityViewModel(database, boxId)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = LearningFragment()
        val args = Bundle().apply {
            putInt(BOX_ID, boxId)
        }
        fragment.apply {
            arguments = args
        }
        fragmentTransaction.add(R.id.container, fragment)
        fragmentTransaction.commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}