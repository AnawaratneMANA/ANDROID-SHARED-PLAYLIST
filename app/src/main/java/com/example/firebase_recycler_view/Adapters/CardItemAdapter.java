package com.example.firebase_recycler_view.Adapters;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.firebase_recycler_view.Mode.CardItem;
import java.util.List;

public class CardItemAdapter extends RecyclerView.Adapter<CardItemAdapter.SearchViewHolder>{

    private Context context;
    private List<CardItem> cardItemList;

    /**
     * Constructor.
     * */
    public CardItemAdapter(Context context, List<CardItem> cardItemList) {
        this.context = context;
        this.cardItemList = cardItemList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<CardItem> getCardItemList() {
        return cardItemList;
    }

    public void setCardItemList(List<CardItem> cardItemList) {
        this.cardItemList = cardItemList;
    }

    /**
     * Getters and Setters
     * */



    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static final class SearchViewHolder extends RecyclerView.ViewHolder {

        public SearchViewHolder(View itemView) {
            super(itemView);
            /**
             * Register Items Here.
             * */
        }

        /**
         * Create a Onclick Listener
         * */
    }



}
