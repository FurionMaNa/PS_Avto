package com.market.ps_avto;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class TagViewHolder extends RecyclerView.ViewHolder {

    private TextView text;

    public TagViewHolder(@NonNull final View itemView) {
        super(itemView);
        text=itemView.findViewById(R.id.text);
    }

    public void bindData(String typeCars) {
        text.setText(typeCars);
    }

}


