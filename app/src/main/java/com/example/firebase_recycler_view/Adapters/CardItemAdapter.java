package com.example.firebase_recycler_view.Adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.firebase_recycler_view.Mode.CardItem;
import com.example.firebase_recycler_view.R;

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
        return new CardItemAdapter.SearchViewHolder(LayoutInflater.from(context).inflate(R.layout.card_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        holder.image.setBackgroundResource(cardItemList.get(position).getImage());
        holder.header.setText(cardItemList.get(position).getName());
        holder.subheader.setText(cardItemList.get(position).getSubname());
    }

    @Override
    public int getItemCount() {
        return cardItemList.size();
    }

    public static final class SearchViewHolder extends RecyclerView.ViewHolder {
        LinearLayout image;
        TextView header;
        TextView subheader;
        TextView description;
        CardView card;

        public SearchViewHolder(View itemView) {
            super(itemView);
            /**
             * Register Items Here.
             * */
            card = itemView.findViewById(R.id.long_card_view_item);
            image = itemView.findViewById(R.id.lcard_image);
            header = itemView.findViewById(R.id.lcard_title);
            subheader = itemView.findViewById(R.id.lcard_second_title);
            description = itemView.findViewById(R.id.lcard_description);

            /**
             * Create a Onclick Listener
             * */
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("Click on the Card");
                }
            });
        }
    }



}
