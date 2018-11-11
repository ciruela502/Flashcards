package martakonik.flashcards.addFlashcard

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.fragment_add_flashcard_back.*
import kotlinx.android.synthetic.main.fragment_add_flashcard_front.*
import martakonik.flashcards.models.Flashcard

const val NON_EXISTING_ID = -1
class AddFlashcardAdapter(fm: FragmentManager?, flashcardId: Int = NON_EXISTING_ID) : FragmentStatePagerAdapter(fm) {

    private val frontFragment = AddFlashcardFragmentFront.create(flashcardId)
    private val backFragment = AddFlashcardFragmentBack.create(flashcardId)

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> frontFragment
            else -> backFragment
        }
    }

    fun createFlashcardFromProvidedInfo(): Flashcard? {
        val newWord = frontFragment.wordEditText.text.toString()
        val newTranslation = backFragment.translationEditText.text.toString()

        return if (!newWord.isBlank() && !newTranslation.isBlank()) {

            val flashcard = Flashcard().apply {
                word = newWord
                translation = newTranslation
            }
            frontFragment.wordEditText.text.clear()
            backFragment.translationEditText.text.clear()
            flashcard
        } else null
    }
}