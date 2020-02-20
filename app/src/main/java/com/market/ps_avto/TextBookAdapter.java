package com.market.ps_avto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TextBookAdapter extends RecyclerView.Adapter<TextBookViewHolder> {

    private ArrayList<Integer> textBook;

    public TextBookAdapter(ArrayList<Integer> textBook) {
        this.textBook = textBook;
    }

    @NonNull
    @Override
    public TextBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_book_cardview,parent,false);
        return  new TextBookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TextBookViewHolder holder, int position) {
        holder.bindData(textBook.get(position));
    }

    @Override
    public int getItemCount() {
        return textBook.size();
    }
}
