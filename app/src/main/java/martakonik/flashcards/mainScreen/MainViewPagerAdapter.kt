package martakonik.flashcards.mainScreen

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import martakonik.flashcards.flashcardsList.ListFragment
import martakonik.flashcards.learning.LearningFragment

class MainViewPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return if (position == 0 ) {
            ListFragment()
        } else {
            LearningFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    fun setCurrentPosition() {
        //todo przez binding w xml
    }
}