package martakonik.flashcards.boxList

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.View
import martakonik.flashcards.data.Box
import martakonik.flashcards.utils.BOX_ID
import martakonik.flashcards.utils.TAG_BOX_MENU

class BoxItemViewModel(
        @get: Bindable
        val box: Box,
        private val supportFragmentManager: FragmentManager
) : BaseObservable() {
    @get: Bindable
    val boxName = box.name

    fun onBoxClick(view: View) {
        val args = Bundle().apply {
            box.id?.let { putInt(BOX_ID, it) }
        }
        val bottomFragment = BoxMenuDialog().apply {
            arguments = args
        }
        bottomFragment.show(supportFragmentManager, TAG_BOX_MENU)
    }
}