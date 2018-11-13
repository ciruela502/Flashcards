package martakonik.flashcards.mainScreen

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import martakonik.flashcards.R
import martakonik.flashcards.boxList.BoxListFragment


class MainViewModel(
        private val addBoxDialog: AddBoxDialog,
        supportFragmentManager: FragmentManager
) {
    private val boxListFragment: Fragment = BoxListFragment()

    init {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, boxListFragment).commit()
    }

    fun onAddClick(view: View) {
        addBoxDialog.show()
    }
}