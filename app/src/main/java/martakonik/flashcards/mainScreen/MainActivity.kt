package martakonik.flashcards.mainScreen

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import martakonik.flashcards.BaseActivity
import martakonik.flashcards.R
import martakonik.flashcards.boxList.BoxListFragment
import martakonik.flashcards.databinding.ActivityMainBinding
import martakonik.flashcards.learning.LearningFragment


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val boxListFragment: Fragment = BoxListFragment()
        val learningFragment: Fragment = LearningFragment()
        showFragment(boxListFragment)

        binding.viewModel = MainViewModel(navigator)

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.flashcard_list -> showFragment(boxListFragment)
                R.id.learning -> showFragment(learningFragment)
            }
            true
        }
    }
    //todo move to vm
    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

}
