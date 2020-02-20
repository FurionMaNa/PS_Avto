package com.market.ps_avto;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ModelViewHolder extends RecyclerView.ViewHolder {

    private TextView text;

    public ModelViewHolder(@NonNull final View itemView) {
        super(itemView);
        text=itemView.findViewById(R.id.text);
    }

    public void bindData(String typeCars) {
        text.setText(typeCars);
    }

}


