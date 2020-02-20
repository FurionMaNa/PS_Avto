package com.market.ps_avto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TypeCarsAdapter extends RecyclerView.Adapter<TypeCarsViewHolder> {

    private ArrayList<Integer> typeCars;

    public TypeCarsAdapter(ArrayList<Integer> typeCars) {
        this.typeCars = typeCars;
    }

    @NonNull
    @Override
    public TypeCarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_type_cardview,parent,false);
        return  new TypeCarsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TypeCarsViewHolder holder, int position) {
        holder.bindData(typeCars.get(position));
    }

    @Override
    public int getItemCount() {
        return typeCars.size();
    }
}
