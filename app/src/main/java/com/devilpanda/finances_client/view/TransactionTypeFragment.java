package com.devilpanda.finances_client.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.devilpanda.finances_client.R;
import com.devilpanda.finances_client.adapters.OnItemClickListener;
import com.devilpanda.finances_client.adapters.TransactionTypeRecyclerViewAdapter;

public class TransactionTypeFragment extends Fragment implements OnItemClickListener {

    private TransactionTypeRecyclerViewAdapter adapter;

    public TransactionTypeFragment() {
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
        return inflater.inflate(R.layout.fragment_type_transaction, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView(view);

    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.transaction_type_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        adapter = new TransactionTypeRecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemListener(View view, int position) {
        Toast.makeText(requireContext(), "Position: " + position, Toast.LENGTH_SHORT).show();
        Navigation.findNavController(view).navigate(R.id.action_addTransactionFragment_to_transactionFragment);
    }
}