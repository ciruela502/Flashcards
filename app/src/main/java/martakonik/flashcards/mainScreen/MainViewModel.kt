package martakonik.flashcards.mainScreen

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import martakonik.flashcards.BR
import martakonik.flashcards.R
import martakonik.flashcards.boxList.BoxListFragment


class MainViewModel(
        private val addBoxDialog: AddBoxDialog,
        supportFragmentManager: FragmentManager
) : BaseObservable() {
    private val manageFloatingButton = { state: Boolean -> changeFloatingState(state)}
    private val boxListFragment: Fragment = BoxListFragment().apply {
        manage = manageFloatingButton
    }

    @get: Bindable
    var floatingState = true

    init {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, boxListFragment).commit()
    }

    fun onAddClick(view: View) {
        addBoxDialog.show()
    }

    private fun changeFloatingState(state: Boolean) {
       floatingState = state
        notifyPropertyChanged(BR.floatingState)
    }
}