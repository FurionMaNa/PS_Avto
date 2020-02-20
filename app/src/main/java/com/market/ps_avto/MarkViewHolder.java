package com.market.ps_avto;

import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MarkViewHolder extends RecyclerView.ViewHolder {

    private TextView markName;
    private CardView cv_mark;

    public MarkViewHolder(@NonNull final View itemView) {
        super(itemView);
        markName=itemView.findViewById(R.id.mark);
        cv_mark=itemView.findViewById(R.id.cv_mark);
    }

    public void bindData(String mark) {

        markName.setText(mark);
        cv_mark.setTag(mark);
        cv_mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransporClass.onClickMark(v);
            }
        });
    }

}


