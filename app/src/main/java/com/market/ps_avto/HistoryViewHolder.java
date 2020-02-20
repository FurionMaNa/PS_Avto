package com.market.ps_avto;

import android.view.View;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryViewHolder  extends RecyclerView.ViewHolder {

    private CardView storis_card;

    public HistoryViewHolder(@NonNull final View itemView) {
        super(itemView);
        storis_card=itemView.findViewById(R.id.storis_card);
    }

    public void bindData(Integer history, final Integer pos) {
        storis_card.setTag(history);
        storis_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransporClass.onClickStoris(v,pos);
            }
        });
    }

}


