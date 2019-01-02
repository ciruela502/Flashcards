package martakonik.flashcards.editFlashcards

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import martakonik.flashcards.Database
import martakonik.flashcards.R
import martakonik.flashcards.addFlashcard.AddFlashcardAdapter
import martakonik.flashcards.models.Flashcard
import martakonik.flashcards.utils.Navigator
import martakonik.flashcards.utils.SnackbarHelper
import org.junit.Test

class EditFlashcardViewModelTest {

    val newFlashcard = Flashcard()
    val database: Database = mock()
    val flashcardId = 0
    val snackbarHelper: SnackbarHelper = mock()
    val adapter: AddFlashcardAdapter = mock() {
        on { createFlashcardFromProvidedInfo() } doReturn newFlashcard
    }
    val navigator: Navigator = mock()

    val tested = EditFlashcardViewModel(database, flashcardId, snackbarHelper, adapter, navigator)

    @Test
    fun `should edit flashcard in database when flashcard is not null when save flashcard called`() {
        tested.saveFlashcard(mock())

        verify(database).editFlashcard(newFlashcard)
    }

    @Test
    fun `should show snackbar when current page is 1 and flashcard is not null when save flashcard called`() {

        tested.saveFlashcard(mock())

        verify(snackbarHelper).showSnackbar(R.string.add_flashcard_succes_message)
    }

    @Test
    fun `should clean when current page is 1 and flashcard is not null when save flashcard called`() {

        tested.saveFlashcard(mock())

    }

    @Test
    fun `should show snackbar current page is 1 and flashcard null when save flashcard called`() {

        tested.saveFlashcard(mock())

        verify(snackbarHelper).showSnackbar(R.string.empty_fields_message)

    }

}