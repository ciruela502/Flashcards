package martakonik.flashcards.addFlashcard

import android.content.res.Resources
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import martakonik.flashcards.Database
import martakonik.flashcards.R
import martakonik.flashcards.models.Flashcard
import martakonik.flashcards.utils.SnackbarHelper
import org.amshove.kluent.shouldEqualTo
import org.junit.Test

class AddFlashCardActivityViewModelTest {

    val newFlashcard = Flashcard()
    val database: Database = mock()
    val adapter: AddFlashcardAdapter = mock() {
        on { createFlashcardFromProvidedInfo() } doReturn newFlashcard
    }
    val snackbarHelper: SnackbarHelper = mock()
    val boxId = 0
    val resources: Resources = mock()

    val tested = AddFlashCardActivityViewModel(database, adapter, snackbarHelper, boxId, resources)

    @Test
    fun `should change increase current page if user is on first page when save flashcard called`() {
        tested.currentPage.get() shouldEqualTo 0

        tested.saveFlashcard(mock())

        tested.currentPage.get() shouldEqualTo 1
    }

    @Test
    fun `should add flashcard to database when current page is 1 and flashcard is not null when save flashcard called`() {
        tested.currentPage.set(1)

        tested.saveFlashcard(mock())

        verify(database).addFlashcard(newFlashcard, boxId)
    }

    @Test
    fun `should show snackbar when current page is 1 and flashcard is not null when save flashcard called`() {
        tested.currentPage.set(1)

        tested.saveFlashcard(mock())

        verify(snackbarHelper).showSnackbar(R.string.add_flashcard_succes_message)
    }

    @Test
    fun `should clean when current page is 1 and flashcard is not null when save flashcard called`() {
        tested.currentPage.set(1)

        tested.saveFlashcard(mock())

        tested.currentPage.get() shouldEqualTo 0
    }

    @Test
    fun `should show snackbar current page is 1 and flashcard null when save flashcard called`() {
        val tested = AddFlashCardActivityViewModel(database, mock(), snackbarHelper, boxId, resources)
        tested.currentPage.set(1)

        tested.saveFlashcard(mock())

        verify(snackbarHelper).showSnackbar(R.string.empty_fields_message)

    }
}