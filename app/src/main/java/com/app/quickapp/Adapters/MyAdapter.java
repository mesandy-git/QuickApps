package com.app.quickapp.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.quickapp.Models.DataModels;
import com.app.quickapp.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<DataModels> items;
    private  Context context;
    private  Boolean flag = false;
    public MyAdapter(List<DataModels> items, Context context) {
        this.items = items;
        this.context= context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        DataModels item = items.get(position);
        holder.srNo.setText(item.getS_No());
        holder.textView.setText(item.getQuestion());
        holder.selected.setImageResource(R.drawable.icon_un_checked3x);
        holder.selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag){
                    holder.selected.setImageResource(R.drawable.icon_checked3x);
                    flag= false;
                }else {
                    holder.selected.setImageResource(R.drawable.icon_un_checked3x);
                    flag= true;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView srNo, textView;
        ImageView selected;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            srNo =  itemView.findViewById(R.id.srNo);
            textView =  itemView.findViewById(R.id.textView);
            selected =  itemView.findViewById(R.id.checkBox);

        }
    }
}
