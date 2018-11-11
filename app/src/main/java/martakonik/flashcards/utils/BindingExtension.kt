package martakonik.flashcards.utils

import android.databinding.BindingAdapter
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.view.View

@BindingAdapter("visibility_value")
fun View.bindVisibility(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("listener")
fun BottomNavigationView.bindListener(listener: BottomNavigationView.OnNavigationItemSelectedListener) {
    setOnNavigationItemSelectedListener(listener)
}

@BindingAdapter("itemDecoration")
fun RecyclerView.addItemDecoration(decoration: DividerItemDecoration) {
    addItemDecoration(decoration)
}