package com.market.ps_avto;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TypeCarsViewHolder extends RecyclerView.ViewHolder {

    private ImageView image;
    private TextView text;

    public TypeCarsViewHolder(@NonNull final View itemView) {
        super(itemView);
        image=itemView.findViewById(R.id.image);
        text=itemView.findViewById(R.id.text);
    }

    public void bindData(Integer typeCars) {
        switch (typeCars){
            case 0:
                image.setImageResource(R.drawable.sedan_test);
                text.setText("Седан");
                break;
            case 1:
                image.setImageResource(R.drawable.hach_test);
                text.setText("Кэтчбек 3дв.");
                break;
            case 2:
                image.setImageResource(R.drawable.sedan_test2);
                text.setText("Кэтчбек 5дв.");
                break;
        }
    }

}


