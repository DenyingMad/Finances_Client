package com.devilpanda.finances_client.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devilpanda.finances_client.R;
import com.devilpanda.finances_client.model.TransactionType;

import java.util.Arrays;
import java.util.List;

public class TransactionTypeRecyclerViewAdapter
        extends RecyclerView.Adapter<TransactionTypeRecyclerViewAdapter.ViewHolder> {

    List<TransactionType> transactionTypes = Arrays.asList(TransactionType.values());
    OnItemClickListener onItemClickListener;

    public TransactionTypeRecyclerViewAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transaction_type_layout, parent, false);
        return new ViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TransactionType transactionType = transactionTypes.get(position);
        holder.transactionTypeName.setText(transactionType.name());
    }

    @Override
    public int getItemCount() {
        return transactionTypes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView transactionTypeName;
        OnItemClickListener onItemClickListener;

        public ViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            transactionTypeName = itemView.findViewById(R.id.transaction_type_name);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemListener(view, getAdapterPosition());
        }
    }
}
