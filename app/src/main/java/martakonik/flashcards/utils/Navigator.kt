package martakonik.flashcards.utils

import android.app.Activity
import android.content.Intent
import martakonik.flashcards.addFlashcard.AddFlashcardActivity
import martakonik.flashcards.editFlashcards.EditFlashcardActivity
import martakonik.flashcards.flashcardsList.FlashcardListActivity
import martakonik.flashcards.learning.LearningActivity

class Navigator(private val activity: Activity) {

    fun openAddFlashcardActivity(boxId: Int) {
        val intent = Intent(activity, AddFlashcardActivity::class.java).apply {
            putExtra("box_id", boxId)
        }
        activity.startActivity(intent)
    }

    fun openLearningActivity(boxId: Int) {
        val intent = Intent(activity, LearningActivity::class.java).apply {
            putExtra("box_id", boxId)
        }
        activity.startActivity(intent)
    }

    fun openFlashcardListActivity(boxId: Int) {
        val intent = Intent(activity, FlashcardListActivity::class.java).apply {
            putExtra("box_id", boxId)
        }
        activity.startActivity(intent)
    }

    fun finishCurrentActivity() {
        activity.finish()
    }

    fun openEditActivity(flashcardId: Int) {
        val intent = Intent(activity, EditFlashcardActivity::class.java).apply {
            putExtra("flashcard_id", flashcardId)
        }
        activity.startActivity(intent)
    }
}