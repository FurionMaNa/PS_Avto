package com.market.ps_avto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentMoreAds extends Fragment {

    public RecyclerView imageRV;
    public ImageCarAdapter imageCarAdapter;
    public ArrayList<Integer> imageArray=new ArrayList<Integer>();
    public TextView all_har;
    public TextView text_har;
    public TextView small_har;
    public TextView vision;
    public TextView WAU_nom;
    public TextView gos_nom;
    public Boolean visible;
    public LinearLayout price;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        visible=false;
        View view = inflater.inflate(R.layout.fragment_more_ads, container, false);
        MainActivity.main_Scroll.scrollTo(0,0);
        imageRV=view.findViewById(R.id.car_photo);
        all_har=view.findViewById(R.id.all_har);
        text_har=view.findViewById(R.id.text_har);
        small_har=view.findViewById(R.id.small_har);
        vision=view.findViewById(R.id.vision);
        WAU_nom=view.findViewById(R.id.WAU_nom);
        gos_nom=view.findViewById(R.id.gos_nom);
        price=view.findViewById(R.id.price);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        imageRV.setLayoutManager(layoutManager1);
        imageArray.add(0);
        imageArray.add(1);
        imageCarAdapter= new ImageCarAdapter(imageArray);
        imageRV.setAdapter(imageCarAdapter);
        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.TP_Price.setVisibility(View.VISIBLE);
                MainActivity.main_scroll.setForeground(getResources().getDrawable( R.drawable.foreground ));
            }
        });
        all_har.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_har.setVisibility(View.VISIBLE);
                small_har.setVisibility(View.VISIBLE);
                all_har.setVisibility(View.GONE);
            }
        });
        small_har.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_har.setVisibility(View.GONE);
                small_har.setVisibility(View.GONE);
                all_har.setVisibility(View.VISIBLE);
            }
        });
        vision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(visible){
                    vision.setText("Показать полный VIN и госномер");
                    WAU_nom.setText("WAU***********");
                    gos_nom.setText("******l54");
                }else{
                    vision.setText("Скрыть полный VIN и госномер");
                    WAU_nom.setText("WAU07895342123");
                    gos_nom.setText("А222ППl54");
                }
                visible=!visible;
            }
        });
        return view;
    }
}
