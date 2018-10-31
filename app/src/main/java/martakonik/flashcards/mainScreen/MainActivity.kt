package martakonik.flashcards.mainScreen

import android.databinding.DataBindingUtil
import android.os.Bundle
import martakonik.flashcards.BaseActivity
import martakonik.flashcards.R
import martakonik.flashcards.databinding.ActivityMainBinding


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val adapter = MainViewPagerAdapter(supportFragmentManager)
        binding.mainViewPager.adapter = adapter
        binding.viewModel = MainViewModel(navigator)

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.flashcard_list -> binding.mainViewPager.currentItem = 0
                R.id.learning -> binding.mainViewPager.currentItem = 1
            }
            true
        }
    }
}
