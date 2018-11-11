package martakonik.flashcards.flashcardsList


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import martakonik.flashcards.databinding.FlashcardListRowBinding
import martakonik.flashcards.models.Flashcard
import martakonik.flashcards.utils.Navigator

class WordsListAdapter(
        data: OrderedRealmCollection<Flashcard>,
        private val navigator: Navigator
) : RealmRecyclerViewAdapter<Flashcard, WordsListAdapter.ViewHolder>(data, true) {

    init {
        setHasStableIds(true)
    }

    override fun getItemId(index: Int): Long = getItem(index)!!.id.toLong()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(FlashcardListRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            viewModel = ListViewModel(getItem(position), navigator)
            executePendingBindings()
        }
    }

    inner class ViewHolder(val binding: FlashcardListRowBinding) : RecyclerView.ViewHolder(binding.root)
}
