package com.market.ps_avto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryAdapter  extends RecyclerView.Adapter<HistoryViewHolder> {

    private ArrayList<Integer> history;

    public HistoryAdapter(ArrayList<Integer> history) {
        this.history = history;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_cardview,parent,false);
        return  new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        holder.bindData(history.get(position),position);
    }

    @Override
    public int getItemCount() {
        return history.size();
    }
}
