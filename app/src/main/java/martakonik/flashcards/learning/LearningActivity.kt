package martakonik.flashcards.learning

import android.os.Bundle
import martakonik.flashcards.BaseActivity
import martakonik.flashcards.R

const val BOX_ID = "box_id"

class LearningActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning)

        val boxId = intent.getIntExtra(BOX_ID, 0)
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
}