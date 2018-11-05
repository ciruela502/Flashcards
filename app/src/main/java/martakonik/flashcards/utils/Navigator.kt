package martakonik.flashcards.utils

import android.content.Context
import android.content.Intent
import martakonik.flashcards.addFlashcard.AddFlashcardActivity
import martakonik.flashcards.flashcardsList.FlashcardListActivity
import martakonik.flashcards.learning.LearningActivity

class Navigator(private val context: Context) {

    fun openAddFlashcardActivity(boxId: Int) {
        val intent = Intent(context, AddFlashcardActivity::class.java).apply {
            putExtra("box_id", boxId)
        }
        context.startActivity(intent)
    }

    fun openLearningActivity(boxId: Int) {
        val intent = Intent(context, LearningActivity::class.java).apply {
            putExtra("box_id", boxId)
        }
        context.startActivity(intent)
    }

    fun openFlashcardListActivity(boxId: Int) {
        val intent = Intent(context, FlashcardListActivity::class.java).apply {
            putExtra("box_id", boxId)
        }
        context.startActivity(intent)
    }
}