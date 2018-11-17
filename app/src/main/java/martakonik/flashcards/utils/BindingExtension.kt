package martakonik.flashcards.utils

import android.databinding.*
import android.support.annotation.NonNull
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.FloatingActionButton
import android.support.v4.view.ViewPager
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.view.View
import android.databinding.adapters.ListenerUtil
import android.databinding.adapters.ListenerUtil.trackListener
import android.support.v4.app.FragmentStatePagerAdapter
import martakonik.flashcards.R


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
@BindingAdapter("adapter")
fun ViewPager.setAdapter(adapter: FragmentStatePagerAdapter) {
    setAdapter(adapter)
}


@BindingMethods(
        BindingMethod(type = ViewPager::class, attribute = "android:currentPage", method = "setCurrentItem"))
object ViewPagerBindAdapter {

    interface OnPageScrolled {
        fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int)
    }

    interface OnPageSelected {
        fun onPageSelected(position: Int)
    }

    interface OnPageScrollStateChanged {
        fun onPageScrollStateChanged(state: Int)
    }

    @JvmStatic
    @InverseBindingAdapter(attribute = "android:currentPage", event = "android:currentPageAttrChanged")
    fun ViewPager.getCurrentPage(): Int {
        return this.currentItem
    }

    @JvmStatic
    @BindingAdapter(value = ["android:onPageScrolled", "android:onPageSelected", "android:onPageScrollStateChanged", "android:currentPageAttrChanged"], requireAll = false)
    fun ViewPager.onSetAdapter(scrolled: OnPageScrolled?,
                               selected: OnPageSelected?,
                               scrollStateChanged: OnPageScrollStateChanged?,
                               currentPageAttrChanged: InverseBindingListener?) {

        val newValue: ViewPager.OnPageChangeListener?
        if (scrolled == null && selected == null && scrollStateChanged == null && currentPageAttrChanged == null) {
            newValue = null
        } else {
            newValue = object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                    scrolled?.onPageScrolled(position, positionOffset, positionOffsetPixels)
                }

                override fun onPageSelected(position: Int) {
                    selected?.onPageSelected(position)
                    currentPageAttrChanged?.onChange()
                }

                override fun onPageScrollStateChanged(state: Int) {
                    scrollStateChanged?.onPageScrollStateChanged(state)
                }
            }
        }
        val oldValue = trackListener(this, newValue, R.id.page_change_listener)
        if (oldValue != null) {
            this.removeOnPageChangeListener(oldValue)
        }
        if (newValue != null) {
            this.addOnPageChangeListener(newValue)
        }
    }
}