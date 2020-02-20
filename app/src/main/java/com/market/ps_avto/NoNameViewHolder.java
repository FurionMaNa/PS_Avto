package com.market.ps_avto;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class NoNameViewHolder extends RecyclerView.ViewHolder {

    private CardView noName;

    public NoNameViewHolder(@NonNull final View itemView) {
        super(itemView);
        noName=itemView.findViewById(R.id.no_name_cardview);
    }

    public void bindData(Integer typeCars) {
        switch (typeCars){
            case 0:
                noName.setCardBackgroundColor(Color.rgb(34,118,211));
                break;
            case 1:
                noName.setCardBackgroundColor(Color.rgb(160,90,241));
                break;
        }
    }

}


