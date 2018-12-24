package martakonik.flashcards.flashcardsList


import android.content.res.Resources
import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import martakonik.flashcards.databinding.FlashcardListRowBinding
import martakonik.flashcards.models.Flashcard

class WordsListAdapter(
        data: OrderedRealmCollection<Flashcard>,
        private val supportFragmentManager: FragmentManager,
        private val resources: Resources
) : RealmRecyclerViewAdapter<Flashcard, WordsListAdapter.ViewHolder>(data, true) {

    init {
        setHasStableIds(true)
    }

    override fun getItemId(index: Int): Long = getItem(index)?.id?.toLong() ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(FlashcardListRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            viewModel = FlashcardListViewModel(
                    getItem(position),
                    supportFragmentManager,
                    checkIfAddHeader(position),
                    resources
            )
            executePendingBindings()
        }
    }

    private fun checkIfAddHeader(position: Int): Boolean {
        when (position) {
            0 -> if (getItem(position)?.partOfBoxId == 0) return true
            itemCount - 1 -> return false
            else -> if (getItem(position - 1)?.partOfBoxId != getItem(position)?.partOfBoxId) {
                return true
            }
        }
        return false
    }

    inner class ViewHolder(val binding: FlashcardListRowBinding) : RecyclerView.ViewHolder(binding.root)
}
