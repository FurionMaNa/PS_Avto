package com.market.ps_avto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TagAdapter extends RecyclerView.Adapter<TagViewHolder> {

    private ArrayList<String> tag;

    public TagAdapter(ArrayList<String> tag) {
        this.tag = tag;
    }

    @NonNull
    @Override
    public TagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tag_cardview,parent,false);
        return  new TagViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TagViewHolder holder, int position) {
        holder.bindData(tag.get(position));
    }

    @Override
    public int getItemCount() {
        return tag.size();
    }
}
