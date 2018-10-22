package martakonik.flashcards.learning

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import com.google.gson.Gson
import martakonik.flashcards.DecreaseStudyLevelUseCase
import martakonik.flashcards.GetNextCardUseCase
import martakonik.flashcards.IncreaseStudyLevelUseCase
import martakonik.flashcards.R
import martakonik.flashcards.models.Flashcard

class LearningViewModel(
        private var childFragmentManager: FragmentManager,
        private var increaseStudyLevel: IncreaseStudyLevelUseCase,
        private var decreaseStudyLevel: DecreaseStudyLevelUseCase,
        private var nextCard: GetNextCardUseCase
) : BaseObservable() {
    var index = 0
    private var showingBack = true
    private var flashcard: Flashcard = Flashcard()
    @get: Bindable
    var backVisible = View.GONE
    @get: Bindable
    var frontVisible = View.VISIBLE

    var boxPartNumber = 0
    @get: Bindable
    var boxPartNumberText = boxPartNumber.toString()

//    private fun getFlascardFromBox(boxPartNumber: Int): List<Flashcard> {
//        val partOfBoxes = box.partOfBoxes
//        // todo change to more sophisticated algorithm
////        for (part in partOfBoxes) {
////            if (!part.flashcards.isEmpty()) {
////                return part.flashcards
////            }
////        }
//        return partOfBoxes[boxPartNumber].flashcards
//    }

    init {
//        flashcard = nextCard.execute(null) //getFlascardFromBox(boxPartNumber)
        flipCard(null)
    }

    fun flipCard(view: View?) {
        if (showingBack) {
            showFront(index)
            backVisible = View.GONE
            frontVisible = View.VISIBLE
            notifyPropertyChanged(backVisible)
            notifyPropertyChanged(frontVisible)
        } else {
            showBack()
            backVisible = View.VISIBLE
            frontVisible = View.GONE
            notifyPropertyChanged(backVisible)
            notifyPropertyChanged(frontVisible)
        }
    }

    private fun showFront(index: Int) {
        flashcard = nextCard.execute(null)
        showingBack = false
        val front = FrontCardFragment()
        showFragment(front)
    }

    private fun showFragment(fragment: Fragment) {
        val bundle = Bundle()
        bundle.putParcelable(CARD, flashcard)
        fragment.arguments = bundle

        childFragmentManager.beginTransaction()
                .setCustomAnimations(
                        R.animator.card_flip_right_in,
                        R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in,
                        R.animator.card_flip_left_out)
                .replace(R.id.container, fragment)

                // Add this transaction to the back stack, allowing users to press
                // Back to get to the front of the card.
                .addToBackStack(null)
                .commit()
    }

    private fun showBack() {
        showingBack = true
        val back = BackCardFragment()
        showFragment(back)

    }

    fun onLearnedClick(view: View) {
//        if (index < flashcards.size) {
            increaseStudyLevel.execute(flashcard)
            flipCard(null)
//        } else {
//            boxPartNumber = boxPartNumber.plus(1)
//            flashcards = getFlascardFromBox(boxPartNumber)
//            flipCard(null)
//            //todo pobierz nastepny box
//            // wyswietl info ze kolejny box
//            // flip
//        }
    }

    fun onNotLearned(view: View) {
        decreaseStudyLevel.execute(flashcard)
        flipCard(null)
    }
}