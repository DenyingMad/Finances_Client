package com.devilpanda.finances_client.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devilpanda.finances_client.R;
import com.devilpanda.finances_client.model.Card;

import java.util.List;

public class HomeCardsRecyclerviewAdapter
        extends RecyclerView.Adapter<HomeCardsRecyclerviewAdapter.ViewHolder> {

    private List<Card> cardList;
    private OnItemClickListener onItemListener;

    public HomeCardsRecyclerviewAdapter(List<Card> cardList, OnItemClickListener onItemListener) {
        this.cardList = cardList;
        this.onItemListener = onItemListener;
    }

    public void update(List<Card> cardList) {
        this.cardList.clear();
        this.cardList.addAll(cardList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (!cardList.isEmpty()) {
            holder.card_name.setText(cardList.get(position).getName());
            holder.card_value.setText(String.valueOf(cardList.get(position).getValue()));
            holder.card_image.setImageResource(R.drawable.money64);
        } else {
            holder.card_name.setText("No cards, add first.");
        }
    }

    @Override
    public int getItemCount() {
        return !cardList.isEmpty() ? cardList.size() : 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView card_name;
        TextView card_value;
        ImageView card_image;
        OnItemClickListener onItemClickListener;

        public ViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            this.onItemClickListener = onItemClickListener;
            card_name = itemView.findViewById(R.id.card_name);
            card_value = itemView.findViewById(R.id.card_value);
            card_image = itemView.findViewById(R.id.card_icon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemListener(view, getAdapterPosition());
        }
    }
}
