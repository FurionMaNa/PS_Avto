package com.market.ps_avto;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class TextBookViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView textHead,text;

    public TextBookViewHolder(@NonNull final View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.image);
        textHead=itemView.findViewById(R.id.textHead);
        text=itemView.findViewById(R.id.text);
    }

    public void bindData(Integer typeCars) {
        switch (typeCars){
            case 0:
                imageView.setImageResource(R.drawable.first_text_book);
                textHead.setText("Звоним продавцу");
                text.setText("Какие вопросы задавать и что попросит у продавца");
                break;
            case 1:
                imageView.setImageResource(R.drawable.second_text_book);
                textHead.setText("Готовимся к осмотру");
                text.setText("Как подойти к процессу осмотра автомобиля грамотно");
                break;
        }
    }

}


