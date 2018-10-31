package martakonik.flashcards.utils

import android.content.Context
import android.content.Intent
import martakonik.flashcards.addFlashcard.AddFlashcardActivity

class Navigator(private val context: Context) {

    fun openAddFlashcardActivity() {
        val intent = Intent(context, AddFlashcardActivity::class.java)
        context.startActivity(intent)
    }
}