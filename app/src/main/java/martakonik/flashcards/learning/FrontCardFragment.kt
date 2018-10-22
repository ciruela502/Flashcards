package martakonik.flashcards.learning

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import martakonik.flashcards.BaseFragment
import martakonik.flashcards.models.Flashcard
import martakonik.flashcards.databinding.FragmentCardFrontBinding

class FrontCardFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentCardFrontBinding.inflate(inflater, container, false)
        var flashcard = arguments?.getParcelable<Flashcard>(CARD)
        binding.viewModel = flashcard?.let { FrontViewModel(it) }
//        binding.wordCardView.setOnClickListener {
////            flipCard()
////        }
        return binding.root
    }



}