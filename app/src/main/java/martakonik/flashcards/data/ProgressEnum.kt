package martakonik.flashcards.data

import martakonik.flashcards.R

enum class ProgressEnum {
    notStarted,
    firstRound,
    secondRound,
    thirdRound,
    lastRound;

    fun getDescription(): Int {
        return when (this) {
            ProgressEnum.notStarted -> R.string.part0
            ProgressEnum.firstRound -> R.string.part1
            ProgressEnum.secondRound -> R.string.part2
            ProgressEnum.thirdRound -> R.string.part3
            ProgressEnum.lastRound -> R.string.part4
        }
    }
}