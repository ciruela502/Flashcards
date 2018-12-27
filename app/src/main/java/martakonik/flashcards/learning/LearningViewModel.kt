package martakonik.flashcards.learning

import android.content.res.Resources
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableBoolean
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import martakonik.flashcards.DecreaseStudyLevelUseCase
import martakonik.flashcards.GetNextCardUseCase
import martakonik.flashcards.IncreaseStudyLevelUseCase
import martakonik.flashcards.R
import martakonik.flashcards.learning.statistic.StatisticFragment
import martakonik.flashcards.models.Flashcard
import martakonik.flashcards.utils.BOX_ID

//todo why var ?
class LearningViewModel(
        private var childFragmentManager: FragmentManager,
        private var increaseStudyLevel: IncreaseStudyLevelUseCase,
        private var decreaseStudyLevel: DecreaseStudyLevelUseCase,
        private var nextCard: GetNextCardUseCase,
        resources: Resources
) : BaseObservable() {
    private val LEARNING_TAG = "learning_fragment"
    private var index = 0
    private var showingBack = true
    private var flashcard: Flashcard = Flashcard()
        set(value) {
            field = value
            learningProgressViewModel.partOfBox.set(field.partOfBoxId)
        }

    @get: Bindable
    val learningProgressViewModel = LearningProgressViewModel(resources)

    @get: Bindable
    var backVisible = ObservableBoolean(false)

    @get: Bindable
    var frontVisible = ObservableBoolean(true)

    @get: Bindable
    var nextSessionVisible = ObservableBoolean(false)

    init {
        flipCard(null)
    }

    fun flipCard(view: View?) {
        if (showingBack) {
            backVisible.set(false)
            frontVisible.set(true)
            showFront(index)
        } else {
            backVisible.set(true)
            frontVisible.set(false)
            showBack()
        }
    }

    fun continueLearning(view: View?) {
        learningProgressViewModel.show()
        flipCard(null)
    }

    private fun showFront(index: Int) {
        val nextFlashcard = nextCard.execute(null)
        if (nextFlashcard != null) {
            nextSessionVisible.set(false)
            flashcard = nextFlashcard
            showingBack = false
            val front = FrontCardFragment()
            showFragment(front)
        } else {
            finishedSession()
        }
    }

    private fun finishedSession() {
        nextSessionVisible.set(true)
        frontVisible.set(false)
        backVisible.set(false)
        learningProgressViewModel.hide()
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
                .replace(R.id.container, fragment, LEARNING_TAG)
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

    fun showStatistic() {
        val bundle = Bundle()
        bundle.putInt(BOX_ID, flashcard.boxId)
        val statisticFragment = StatisticFragment().apply {
            arguments = bundle
        }

        childFragmentManager.beginTransaction()
                .setCustomAnimations(
                        R.animator.card_flip_right_in,
                        R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in,
                        R.animator.card_flip_left_out)
                .replace(R.id.container, statisticFragment, LEARNING_TAG)
                .commit()

    }
}