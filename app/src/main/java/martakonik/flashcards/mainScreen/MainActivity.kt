package martakonik.flashcards.mainScreen

import android.databinding.DataBindingUtil
import android.os.Bundle
import io.reactivex.rxkotlin.addTo
import martakonik.flashcards.BaseActivity
import martakonik.flashcards.R
import martakonik.flashcards.boxList.BoxListAdapter
import martakonik.flashcards.databinding.ActivityMainBinding


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        val addBoxDialog = AddBoxDialog(this, database)

        database.getBoxList().subscribe { it ->
            val adapter = BoxListAdapter(it, supportFragmentManager)
            binding.viewModel = MainViewModel(addBoxDialog, adapter, database)
        }.addTo(compositeDisposable)

    }
}
