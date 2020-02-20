package com.market.ps_avto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ParamsAdapter extends RecyclerView.Adapter<ParamsViewHolder> {

    private ArrayList<ParamsClass> tag;

    public ParamsAdapter(ArrayList<ParamsClass> tag) {
        this.tag = tag;
    }

    @NonNull
    @Override
    public ParamsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.params_cardview,parent,false);
        return  new ParamsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParamsViewHolder holder, int position) {
        holder.bindData(tag.get(position),position);
    }

    @Override
    public int getItemCount() {
        return tag.size();
    }
}
