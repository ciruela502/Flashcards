package martakonik.flashcards.learning.statistic

import android.databinding.BaseObservable
import android.databinding.Bindable
import martakonik.flashcards.data.Box

class StatisticViewModel(box: Box) : BaseObservable() {

    @get:Bindable
    val partZeroValue = box.partOfBoxes[0]?.flashcards?.size.toString()

    @get:Bindable
    val partFirstValue = box.partOfBoxes[1]?.flashcards?.size.toString()

    @get:Bindable
    val partSecondValue = box.partOfBoxes[2]?.flashcards?.size.toString()

    @get:Bindable
    val partThirdValue = box.partOfBoxes[3]?.flashcards?.size.toString()

    @get:Bindable
    val partLastValue = box.partOfBoxes[4]?.flashcards?.size.toString()

}