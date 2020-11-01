package com.devilpanda.finances_client.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devilpanda.finances_client.adapters.HomeCardsRecyclerviewAdapter;
import com.devilpanda.finances_client.model.Card;
import com.devilpanda.finances_client.repository.CardsRepository;

import java.util.ArrayList;
import java.util.List;

public class CardsViewModel extends ViewModel {

    public static final String TAG = "CardsVM";

    private CardsRepository cardsRepository;

    private MutableLiveData<List<Card>> cardList;
    private final MutableLiveData<Card> selectedCard = new MutableLiveData<>();

    public void init() {
        if (cardsRepository == null) {
            cardsRepository = CardsRepository.getInstance();
        }
    }

    public LiveData<List<Card>> getCards() {
        if (cardList == null) {
            cardList = cardsRepository.getAllCards();
        }
        return cardList;
    }

    public void select(Card selectedCard) {
        this.selectedCard.setValue(selectedCard);
    }
    public LiveData<Card> getSelectedCard() {
        return selectedCard;
    }

}
