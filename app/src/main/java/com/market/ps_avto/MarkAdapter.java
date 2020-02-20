package com.market.ps_avto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MarkAdapter extends RecyclerView.Adapter<MarkViewHolder> {

    private ArrayList<String> mark;

    public MarkAdapter(ArrayList<String> mark) {
        this.mark = mark;
    }

    @NonNull
    @Override
    public MarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mark_car_cardview,parent,false);
        return  new MarkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MarkViewHolder holder, int position) {
        holder.bindData(mark.get(position));
    }

    @Override
    public int getItemCount() {
        return mark.size();
    }
}
