package com.devilpanda.finances_client.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.devilpanda.finances_client.R;
import com.devilpanda.finances_client.model.Card;
import com.devilpanda.finances_client.viewmodel.CardsViewModel;

public class CardDetailsFragment extends Fragment {

    private CardsViewModel cardsViewModel;
    private TextView cardName;
    private TextView cardBalance;
    private Button settings;

    public CardDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cardsViewModel = new ViewModelProvider(requireActivity()).get(CardsViewModel.class);
        cardsViewModel.init();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cardName = view.findViewById(R.id.details_card_name);
        cardBalance = view.findViewById(R.id.details_card_balance);
        cardsViewModel.getSelectedCard().observe(getViewLifecycleOwner(), new Observer<Card>() {
            @Override
            public void onChanged(Card card) {
                cardName.setText(card.getName());
                String balanceValue = card.getValue() + " rub";
                cardBalance.setText(balanceValue);
            }
        });
    }
}