package martakonik.flashcards.learning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import martakonik.flashcards.BaseFragment
import martakonik.flashcards.databinding.FragmentCardBackBinding
import martakonik.flashcards.models.Flashcard

class BackCardFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
//        super.onCreateView(inflater, container, savedInstanceState)
        val binding = FragmentCardBackBinding.inflate(inflater, container, false)

        val flashcard = arguments?.getParcelable<Flashcard>(CARD)
        binding.viewModel = flashcard?.let { BackViewModel(it) }

//        binding.ok.setOnLongClickListener {
//            //show another learner fragment
//
//        }
        return binding.root
    }

}