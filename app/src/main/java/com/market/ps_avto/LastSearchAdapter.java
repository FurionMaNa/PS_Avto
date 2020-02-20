package com.market.ps_avto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LastSearchAdapter extends RecyclerView.Adapter<LastSearchViewHolder> {

    private ArrayList<String> lastSearch;

    public LastSearchAdapter(ArrayList<String> lastSearch) {
        this.lastSearch = lastSearch;
    }

    @NonNull
    @Override
    public LastSearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.last_search_cardview,parent,false);
        return  new LastSearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LastSearchViewHolder holder, int position) {
        holder.bindData(lastSearch.get(position));
    }

    @Override
    public int getItemCount() {
        return lastSearch.size();
    }
}
