package com.market.ps_avto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ModelAdapter extends RecyclerView.Adapter<ModelViewHolder> {

    private ArrayList<String> models;

    public ModelAdapter(ArrayList<String> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_cardview,parent,false);
        return  new ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelViewHolder holder, int position) {
        holder.bindData(models.get(position));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
