package martakonik.flashcards.boxList

import android.support.v4.app.FragmentManager
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyZeroInteractions
import martakonik.flashcards.Database
import martakonik.flashcards.utils.Navigator
import org.junit.Test

class BoxMenuViewModelTest {

    val navigator: Navigator = mock()
    val database: Database = mock()
    val boxId = 0
    val boxMenuDialog: BoxMenuDialog = mock()

    val tested = BoxMenuViewModel(navigator, database, boxId, boxMenuDialog)

    @Test
    fun `should open learning activity when on learning click`() {
        verifyZeroInteractions(navigator)

        tested.onLearningClick(mock())

        verify(navigator).openLearningActivity(boxId)
    }

    @Test
    fun `should dismiss dialog when on learning click`() {
        verifyZeroInteractions(boxMenuDialog)

        tested.onLearningClick(mock())

        verify(boxMenuDialog).dismiss()
    }

    @Test
    fun `should flashcard list activity when on show flashcard click`() {
        verifyZeroInteractions(navigator)

        tested.onShowFlashcardsClick(mock())

        verify(navigator).openFlashcardListActivity(boxId)
    }

    @Test
    fun `should dismiss dialog when on show flashcard click`() {
        verifyZeroInteractions(boxMenuDialog)

        tested.onShowFlashcardsClick(mock())

        verify(boxMenuDialog).dismiss()
    }

    @Test
    fun `should open add flashcard activity when on add flashcard click`() {
        verifyZeroInteractions(navigator)

        tested.onAddFlashcardsClick(mock())

        verify(navigator).openAddFlashcardActivity(boxId)
    }

    @Test
    fun `should dismiss dialog when on add flashcard click`() {
        verifyZeroInteractions(boxMenuDialog)

        tested.onAddFlashcardsClick(mock())

        verify(boxMenuDialog).dismiss()
    }
}