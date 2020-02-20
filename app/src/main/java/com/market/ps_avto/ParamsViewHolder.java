package com.market.ps_avto;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ParamsViewHolder extends RecyclerView.ViewHolder {

    private TextView text;
    private CardView panel;
    private ImageButton cancel;

    public ParamsViewHolder(@NonNull final View itemView) {
        super(itemView);
        text=itemView.findViewById(R.id.text);
        panel=itemView.findViewById(R.id.panel);
        cancel=itemView.findViewById(R.id.cancel);
    }

    public void bindData(final ParamsClass params, final Integer pos) {
        if(params.getSelect()){
            if(pos>0){
                cancel.setVisibility(View.VISIBLE);
            }
            panel.setBackgroundResource(R.drawable.look_btn);
            text.setTextColor(Color.WHITE);
        }else{
            if(pos>0){
                cancel.setVisibility(View.GONE);
            }
            panel.setBackgroundResource(R.drawable.white_panel);
            text.setTextColor(Color.BLACK);
        }
        text.setText(params.getName());
        panel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTireRims.onClickParams(params.getType(),pos);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTireRims.onClickDeleteParams(params.getType(),pos);
            }
        });
    }

}


