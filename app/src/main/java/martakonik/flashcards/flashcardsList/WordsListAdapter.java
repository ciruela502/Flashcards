package martakonik.flashcards.flashcardsList;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import martakonik.fiszki.domain.models.Flashcard;
import martakonik.flashcards.R;

public class WordsListAdapter extends RecyclerView.Adapter<WordsListAdapter.ViewHolder> {

    private List<Flashcard> flashcards;

    public WordsListAdapter(List<Flashcard> flashcards) {
        this.flashcards = flashcards;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.flashcard_list_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Flashcard flashcard = flashcards.get(position);
        holder.mTextViewWord.setText(flashcard.getWord());
        holder.mTextViewTranslation.setText(flashcard.getTranslation());
    }

    @Override
    public int getItemCount() {
        return flashcards.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextViewWord = itemView.findViewById(R.id.text_view_translation);
        TextView mTextViewTranslation = itemView.findViewById(R.id.text_view_word);

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
