package com.devilpanda.finances_client.repository;

import androidx.lifecycle.MutableLiveData;

import com.devilpanda.finances_client.model.Card;

import java.util.ArrayList;
import java.util.List;

public class CardsRepository {
    private static CardsRepository instance;

    public static CardsRepository getInstance() {
        if (instance == null) {
            instance = new CardsRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Card>> getAllCards() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card("Card 1", 50000.0d));
        cardList.add(new Card("Card 2", 500_000.52d));
        MutableLiveData<List<Card>> data = new MutableLiveData<>();
        data.setValue(cardList);
        return data;
    }
}
