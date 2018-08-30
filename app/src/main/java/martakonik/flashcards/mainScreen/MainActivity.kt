package martakonik.flashcards.mainScreen

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import martakonik.flashcards.R
import martakonik.flashcards.databinding.ActivityMainBinding
import martakonik.flashcards.flashcardsList.WordsListAdapter
import martakonik.flashcards.services.MockedBoxService


class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
//todo wymyslec switne menu na elementy: viepagerr i taby ? - do fragmentu
        //nowe fiszki
        //uczenie
        val boxService = MockedBoxService()
        val flashcards = boxService.box.partOfBoxes[0].flashcards

        binding.flashcardList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = WordsListAdapter(flashcards)
        }
//        binding.viewModel = MainViewModel()
    }
}
