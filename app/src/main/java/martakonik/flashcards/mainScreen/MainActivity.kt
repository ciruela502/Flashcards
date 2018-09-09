package martakonik.flashcards.mainScreen

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import martakonik.flashcards.R
import martakonik.flashcards.databinding.ActivityMainBinding
import martakonik.flashcards.flashcardsList.WordsListAdapter
import martakonik.flashcards.services.MockedBoxService
import android.support.annotation.NonNull
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem


class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
//todo wymyslec switne menu na elementy: viepagerr i taby ? - do fragmentu
        //nowe fiszki
        //uczenie
        var adapter = MainViewPagerAdapter(supportFragmentManager)
        binding.mainViewPager.adapter = adapter
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
R.id.flashcard_list -> adapter.setCurrentPosition()
            }
            true
        }
//        }
//        binding.viewModel = MainViewModel()
    }
}
