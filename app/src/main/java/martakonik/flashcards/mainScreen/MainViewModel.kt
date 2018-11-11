package martakonik.flashcards.mainScreen

import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import martakonik.flashcards.R
import martakonik.flashcards.boxList.BoxListFragment
import martakonik.flashcards.learning.LearningFragment


class MainViewModel(
        private val addBoxDialog: AddBoxDialog,
        private val supportFragmentManager: FragmentManager
) {
    private val boxListFragment: Fragment = BoxListFragment()
    private val learningFragment: Fragment = LearningFragment()

    init {
        showFragment(boxListFragment)
    }

    fun onAddClick(view: View) {
        addBoxDialog.show()
    }

    val navigationListener = BottomNavigationView.OnNavigationItemSelectedListener{ item ->
        when (item.itemId) {
            R.id.flashcard_list -> showFragment(boxListFragment)
            R.id.learning -> showFragment(learningFragment)
        }
        true
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }
}