package com.market.ps_avto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoNameAdapter extends RecyclerView.Adapter<NoNameViewHolder> {

    private ArrayList<Integer> typeCars;

    public NoNameAdapter(ArrayList<Integer> typeCars) {
        this.typeCars = typeCars;
    }

    @NonNull
    @Override
    public NoNameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.no_name_cardview,parent,false);
        return  new NoNameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoNameViewHolder holder, int position) {
        holder.bindData(typeCars.get(position));
    }

    @Override
    public int getItemCount() {
        return typeCars.size();
    }
}
