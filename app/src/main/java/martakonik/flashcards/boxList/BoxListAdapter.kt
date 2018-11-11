package martakonik.flashcards.boxList

import android.support.constraint.ConstraintLayout
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.realm.RealmRecyclerViewAdapter
import io.realm.RealmResults
import martakonik.flashcards.data.Box
import martakonik.flashcards.databinding.BoxListItemBinding

class BoxListAdapter(
        data: RealmResults<Box>,
        private val sheetBehavior: BottomSheetBehavior<ConstraintLayout?>?
) : RealmRecyclerViewAdapter<Box, BoxListAdapter.ViewHolder>(data, true) {
    lateinit var choosenBox: (Int) -> Any

    init {
        setHasStableIds(true)
    }
    override fun getItemId(index: Int): Long = getItem(index)!!.id?.toLong()!!

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoxListAdapter.ViewHolder =
        ViewHolder(BoxListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: BoxListAdapter.ViewHolder, position: Int) {
        holder.binding.apply {
            viewModel = getItem(position)?.let { BoxItemViewModel(it, sheetBehavior, choosenBox) }
            executePendingBindings()
        }
    }

    inner class ViewHolder(val binding: BoxListItemBinding) : RecyclerView.ViewHolder(binding.root)

}