package com.devilpanda.finances_client.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devilpanda.finances_client.R;
import com.devilpanda.finances_client.adapters.HomeCardsRecyclerviewAdapter;
import com.devilpanda.finances_client.adapters.OnItemClickListener;
import com.devilpanda.finances_client.model.Card;
import com.devilpanda.finances_client.viewmodel.CardsViewModel;

import java.util.ArrayList;
import java.util.List;

public class WalletFragment extends Fragment implements OnItemClickListener {

    private List<Card> cardList = new ArrayList<>();
    private CardsViewModel cardsViewModel;

    private HomeCardsRecyclerviewAdapter adapter;

    public WalletFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cardsViewModel = new ViewModelProvider(requireActivity()).get(CardsViewModel.class);
        cardsViewModel.init();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initRecyclerView(view);

        cardsViewModel.getCards().observe(getViewLifecycleOwner(), new Observer<List<Card>>() {
            @Override
            public void onChanged(List<Card> cards) {
                adapter.update(cards);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wallet, container, false);
    }

    @Override
    public void onItemListener(View view, int position) {
        cardsViewModel.select(cardList.get(position));
        Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_cardDetailsFragment);
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.cards_recyclerview);
        adapter = new HomeCardsRecyclerviewAdapter(cardList, this);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                if (parent.getChildAdapterPosition(view) % 2 == 0) {
                    outRect.left = 40;
                }
                outRect.right = 40;
                outRect.top = 40;
                outRect.bottom = 40;
            }
        });
    }
}