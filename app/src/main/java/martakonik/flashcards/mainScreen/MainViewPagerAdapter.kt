package martakonik.flashcards.mainScreen

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import martakonik.flashcards.boxList.BoxListFragment
import martakonik.flashcards.learning.LearningFragment

class MainViewPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> BoxListFragment()
            else -> LearningFragment()
        }
    }

    override fun getCount(): Int = 3
}