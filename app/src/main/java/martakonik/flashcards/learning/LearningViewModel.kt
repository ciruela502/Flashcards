package martakonik.flashcards.learning

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
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
    private var index = 0
    private var showingBack = true
    private var flashcard: Flashcard = Flashcard()
    private var boxPartNumber = 0

    @get: Bindable
    var backVisible = View.GONE

    @get: Bindable
    var frontVisible = View.VISIBLE

    init {
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
                .addToBackStack(null)
                .commit()
    }

    private fun showBack() {
        showingBack = true
        val back = BackCardFragment()
        showFragment(back)

    }

    fun onLearnedClick(view: View) {
        increaseStudyLevel.execute(flashcard)
        flipCard(null)
    }

    fun onNotLearned(view: View) {
        decreaseStudyLevel.execute(flashcard)
        flipCard(null)
    }
}