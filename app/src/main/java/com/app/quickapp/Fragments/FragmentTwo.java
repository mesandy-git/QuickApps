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

public class FragmentTwo extends Fragment {
    private RecyclerView recyclerView;
    private List<DataModels> dataList = new ArrayList<>();
    private MyAdapter myAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_fragment_two, container, false);
        recyclerView =view.findViewById(R.id.recyclerView);
        createList();
        myAdapter = new MyAdapter(dataList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return view;

    }
    private void createList() {
        DataModels myAdapter = new DataModels("(1)","Page 2, This is the 1st", true);
        dataList.add(myAdapter);
        myAdapter = new DataModels("(2)","Page 2, This is the 2nd", false);
        dataList.add(myAdapter);
        myAdapter = new DataModels("(3)","Page 2, This is the 3rd", true);
        dataList.add(myAdapter);
        myAdapter = new DataModels("(4)","Page 2, This is the 4th", false);
        dataList.add(myAdapter);
        myAdapter = new DataModels("(5)","Page 2, This is the 5th", true);
        dataList.add(myAdapter);
        myAdapter = new DataModels("(6)","Page 2, This is the 6th", false);
        dataList.add(myAdapter);
        myAdapter = new DataModels("(7)","Page 2, This is the 7th", true);
        dataList.add(myAdapter);
    }

}
