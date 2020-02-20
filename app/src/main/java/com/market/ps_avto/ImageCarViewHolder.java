package com.market.ps_avto;

import android.graphics.Color;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ImageCarViewHolder extends RecyclerView.ViewHolder {

    private CardView imageCar;

    public ImageCarViewHolder(@NonNull final View itemView) {
        super(itemView);
        imageCar=itemView.findViewById(R.id.image_cardView);
    }

    public void bindData(Integer typeCars) {
        switch (typeCars){
            case 0:
                imageCar.setCardBackgroundColor(Color.rgb(34,118,211));
                break;
            case 1:
                imageCar.setCardBackgroundColor(Color.rgb(160,90,241));
                break;
        }
    }

}


