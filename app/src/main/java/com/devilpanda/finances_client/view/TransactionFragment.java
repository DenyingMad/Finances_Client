package com.devilpanda.finances_client.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import com.devilpanda.finances_client.R;
import com.devilpanda.finances_client.adapters.ChooseCardSpinnerAdapter;
import com.devilpanda.finances_client.model.Card;

import java.util.ArrayList;
import java.util.List;

public class TransactionFragment extends Fragment {

    private ChooseCardSpinnerAdapter spinnerAdapter;

    public TransactionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transaction, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card("Card 1", 100_000.95));
        cardList.add(new Card("Card 2", 37_400.0));

        spinnerAdapter = new ChooseCardSpinnerAdapter(view.getContext(), cardList);

        Button button = view.findViewById(R.id.transaction_next_button);
        Spinner spinner = view.findViewById(R.id.transaction_select_card_spinner);
        spinner.setAdapter(spinnerAdapter);
    }
}