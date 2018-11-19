package martakonik.flashcards.learning

import android.content.res.Resources
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableInt
import martakonik.flashcards.R
import martakonik.flashcards.data.ProgressEnum

class LearningProgressViewModel(private val resources: Resources) : BaseObservable() {

    @get:Bindable
    val textNotStarted: String = resources.getString(ProgressEnum.notStarted.getDescription())

    @get:Bindable
    val textFirstRound: String = resources.getString(ProgressEnum.firstRound.getDescription())

    @get:Bindable
    val textSecondRound: String = resources.getString(ProgressEnum.secondRound.getDescription())

    @get:Bindable
    val textThirdRound: String = resources.getString(ProgressEnum.thirdRound.getDescription())

    @get:Bindable
    val textLastRound: String = resources.getString(ProgressEnum.lastRound.getDescription())

    @get:Bindable("partOfBox")
    val colorNotStarted: Int
        get() = if (partOfBox.get() == ProgressEnum.notStarted.ordinal) resources.getColor(R.color.colorPrimaryDark) else resources.getColor(R.color.grey)

    @get:Bindable("partOfBox")
    val colorFirstRound: Int
        get() = if (partOfBox.get() == ProgressEnum.firstRound.ordinal) resources.getColor(R.color.colorPrimaryDark) else resources.getColor(R.color.grey)

    @get:Bindable("partOfBox")
    val colorSecondRound: Int
        get() = if (partOfBox.get() == ProgressEnum.secondRound.ordinal) resources.getColor(R.color.colorPrimaryDark) else resources.getColor(R.color.grey)

    @get:Bindable("partOfBox")
    val colorThirdRound: Int
        get() = if (partOfBox.get() == ProgressEnum.thirdRound.ordinal) resources.getColor(R.color.colorPrimaryDark) else resources.getColor(R.color.grey)

    @get:Bindable("partOfBox")
    val colorLastRound: Int
        get() = if (partOfBox.get() == ProgressEnum.lastRound.ordinal) resources.getColor(R.color.colorPrimaryDark) else resources.getColor(R.color.grey)

    var partOfBox = ObservableInt()
}