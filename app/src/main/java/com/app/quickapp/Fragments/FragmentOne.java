package com.app.quickapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.quickapp.Models.DataModels;
import com.app.quickapp.Adapters.MyAdapter;
import com.app.quickapp.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentOne extends Fragment {
    private RecyclerView recyclerView;
    private List<DataModels> dataList = new ArrayList<>();
    private MyAdapter myAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_fragment_one, container, false);
        recyclerView =view.findViewById(R.id.recyclerView);
        createList();
        myAdapter = new MyAdapter(dataList, getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return view;
    }

    private void createList() {
        dataList.clear();
        DataModels myAdapter = new DataModels("a","Text will be display here Text will be display here " +
                "Text will be display here", true);
        dataList.add(myAdapter);
        myAdapter = new DataModels("b","Page 1, This is the 2nd", false);
        dataList.add(myAdapter);
        myAdapter = new DataModels("c","Text will be display here Text will be display here " +
                "Text will be display here", true);
        dataList.add(myAdapter);
        myAdapter = new DataModels("d","Page 1, This is the 4th", false);
        dataList.add(myAdapter);
        myAdapter = new DataModels("d","Page 1, This is the 5th", true);
        dataList.add(myAdapter);
        myAdapter = new DataModels("e","Page 1, This is the 6th", false);
        dataList.add(myAdapter);
        myAdapter = new DataModels("f","Page 1, This is the 7th", true);
        dataList.add(myAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
