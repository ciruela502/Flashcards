package martakonik.flashcards.mainScreen

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import martakonik.flashcards.addFlashcard.AddFlashcardFragment
import martakonik.flashcards.flashcardsList.ListFragment
import martakonik.flashcards.learning.LearningFragment

class MainViewPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ListFragment()
            1 -> AddFlashcardFragment()
            else -> LearningFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    fun setCurrentPosition() {
        //todo przez binding w xml
    }
}