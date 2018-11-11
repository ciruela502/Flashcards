package martakonik.flashcards.utils

import android.databinding.BindingAdapter
import android.support.design.widget.BottomNavigationView
import android.view.View

@BindingAdapter("visibility_value")
fun View.bindVisibility(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("listener")
fun BottomNavigationView.bindListener(listener: BottomNavigationView.OnNavigationItemSelectedListener) {
    setOnNavigationItemSelectedListener(listener)
}