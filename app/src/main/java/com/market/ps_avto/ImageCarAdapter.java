package com.market.ps_avto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageCarAdapter extends RecyclerView.Adapter<ImageCarViewHolder> {

    private ArrayList<Integer> imageCar;

    public ImageCarAdapter(ArrayList<Integer> imageCar) {
        this.imageCar = imageCar;
    }

    @NonNull
    @Override
    public ImageCarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_car_cardview,parent,false);
        return  new ImageCarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageCarViewHolder holder, int position) {
        holder.bindData(imageCar.get(position));
    }

    @Override
    public int getItemCount() {
        return imageCar.size();
    }
}
