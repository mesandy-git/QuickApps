package com.app.quickapp.Adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.quickapp.Models.DataModels;
import com.app.quickapp.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<DataModels> items;
    public MyAdapter(List<DataModels> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataModels item = items.get(position);
        holder.srNo.setText(item.getS_No());
        holder.textView.setText(item.getQuestion());
        holder.selected.setChecked(item.isSelect());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView srNo, textView;
        public CheckBox selected;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            srNo =  itemView.findViewById(R.id.srNo);
            textView =  itemView.findViewById(R.id.textView);
            selected =  itemView.findViewById(R.id.checkBox);

        }
    }
}
