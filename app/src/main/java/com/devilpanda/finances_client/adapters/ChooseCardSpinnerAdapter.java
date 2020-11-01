package com.devilpanda.finances_client.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.devilpanda.finances_client.R;
import com.devilpanda.finances_client.model.Card;

import java.util.List;

public class ChooseCardSpinnerAdapter extends BaseAdapter {

    private List<Card> cardList;
    LayoutInflater layoutInflater;

    public ChooseCardSpinnerAdapter(Context context, List<Card> cardList) {
        this.cardList = cardList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return cardList.size();
    }

    @Override
    public Object getItem(int i) {
        return cardList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = layoutInflater.inflate(R.layout.card_layout, viewGroup, false);

        ImageView imageView = v.findViewById(R.id.card_icon);
        TextView cardName = v.findViewById(R.id.card_name);
        TextView cardBalance = v.findViewById(R.id.card_value);

        imageView.setImageResource(R.drawable.money64);
        cardName.setText(cardList.get(i).getName());
        cardBalance.setText(String.valueOf(cardList.get(i).getValue()));

        return v;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View v = layoutInflater.inflate(R.layout.card_layout, parent, false);

        ImageView imageView = v.findViewById(R.id.card_icon);
        TextView cardName = v.findViewById(R.id.card_name);
        TextView cardBalance = v.findViewById(R.id.card_value);

        imageView.setImageResource(R.drawable.money64);
        cardName.setText(cardList.get(position).getName());
        cardBalance.setText(String.valueOf(cardList.get(position).getValue()));

        return v;
    }
}
