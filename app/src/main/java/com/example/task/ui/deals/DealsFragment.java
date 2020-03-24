package com.example.task.ui.deals;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task.Adapter.DealsAdapter;
import com.example.task.Model.Deals_details;
import com.example.task.R;

import java.util.ArrayList;
import java.util.List;

public class DealsFragment extends Fragment {
    RecyclerView recyclerView;
    DealsAdapter dealsAdapter;
    List<Deals_details> deals_details;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        deals_details = new ArrayList<>();
        deals_details.add(new Deals_details("50","Home & Cleaning",R.drawable.clean));
        deals_details.add(new Deals_details("40","Oil & Rice",R.drawable.oil));
        deals_details.add(new Deals_details("35","Diary",R.drawable.diary));

        deals_details.add(new Deals_details("30","Biscuits and cookies",R.drawable.biscut));

        deals_details.add(new Deals_details("25","Beverages",R.drawable.beverage));

        deals_details.add(new Deals_details("25","Frozen food",R.drawable.frozen));

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deals, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        recyclerView = view.findViewById(R.id.mRecyclerview);
        dealsAdapter = new DealsAdapter(getContext(), deals_details);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(dealsAdapter);

        return view;
    }
}