package com.app.quickapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.quickapp.Models.DataModels;
import com.app.quickapp.Adapters.MyAdapter;
import com.app.quickapp.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentThree extends Fragment {
    private RecyclerView recyclerView;
    private List<DataModels> dataList = new ArrayList<>();
    private MyAdapter myAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_fragment_three, container, false);
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
        DataModels myAdapter = new DataModels("(1)","Page 3, This is the 1st", true);
        dataList.add(myAdapter);
        myAdapter = new DataModels("a","Page 3, This is the 2nd", false);
        dataList.add(myAdapter);
        myAdapter = new DataModels("b","Page 3, This is the 3rd", true);
        dataList.add(myAdapter);
        myAdapter = new DataModels("c","Page 3, This is the 4th", false);
        dataList.add(myAdapter);
        myAdapter = new DataModels("d","Page 3, This is the 5th", true);
        dataList.add(myAdapter);
        myAdapter = new DataModels("e","Page 3, This is the 6th", false);
        dataList.add(myAdapter);
        myAdapter = new DataModels("f","Page 3, This is the 7th", true);
        dataList.add(myAdapter);
    }
}
