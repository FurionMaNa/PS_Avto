package com.market.ps_avto;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentTireRims extends Fragment {

    public static ArrayList<ParamsClass> paramsArray= new ArrayList<ParamsClass>();
    public RecyclerView params;
    public static ParamsAdapter paramsAdapter;
    public RecyclerView tag;
    public ArrayList<String> nameTag=new ArrayList<String >();
    public TagAdapter tagAdapter;
    public static FragmentActivity activity;
    public static FragmentManager manager;
    public Button tire_btn;
    public Button rims_btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tire_rims, container, false);
        MainActivity.clMainToolBar.setVisibility(View.GONE);
        MainActivity.clProductToolBar.setVisibility(View.VISIBLE);
        MainActivity.setting_ll.setVisibility(View.VISIBLE);
        activity= (FragmentActivity)view.getContext();
        manager= activity.getSupportFragmentManager();
        params=view.findViewById(R.id.params);
        tag=view.findViewById(R.id.tag);
        tire_btn=view.findViewById(R.id.tire_btn);
        rims_btn=view.findViewById(R.id.rims_btn);
        paramsArray.add(new ParamsClass(true,"Зима",0));
        paramsArray.add(new ParamsClass(false,"Ширина,мм",1));
        paramsArray.add(new ParamsClass(false,"Высота, %",2));
        paramsArray.add(new ParamsClass(false,"Диаметр,\"",3));
        paramsArray.add(new ParamsClass(false,"Шипы",4));
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        params.setLayoutManager(layoutManager1);
        paramsAdapter= new ParamsAdapter(paramsArray);
        params.setAdapter(paramsAdapter);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        tag.setLayoutManager(layoutManager2);
        nameTag.add("LRD4-000117");
        nameTag.add("Land Rover");
        nameTag.add("Новый");
        nameTag.add("В наличии");
        nameTag.add("100x100");
        nameTag.add("Металл");
        tagAdapter= new TagAdapter(nameTag);
        tag.setAdapter(tagAdapter);

        tire_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tire_btn.setBackgroundResource(R.drawable.left_type_btn_select);
                tire_btn.setTextColor(Color.WHITE);
                rims_btn.setBackgroundResource(R.drawable.right_type_btn_no_select);
                rims_btn.setTextColor(Color.parseColor("#B4B4B4"));
            }
        });

        rims_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tire_btn.setBackgroundResource(R.drawable.left_type_btn_no_select);
                tire_btn.setTextColor(Color.parseColor("#B4B4B4"));
                rims_btn.setBackgroundResource(R.drawable.right_type_btn_select);
                rims_btn.setTextColor(Color.WHITE);
            }
        });

        MainActivity.widthRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio1:
                        paramsArray.set(1,new ParamsClass(true,"Ширина 110 мм",1));
                        break;
                    case R.id.radio2:
                        paramsArray.set(1,new ParamsClass(true,"Ширина 115 мм",1));

                        break;
                    case R.id.radio3:
                        paramsArray.set(1,new ParamsClass(true,"Ширина 120 мм",1));
                        break;
                    case R.id.radio4:
                        paramsArray.set(1,new ParamsClass(true,"Ширина 125 мм",1));
                        break;
                    case R.id.radio5:
                        paramsArray.set(1,new ParamsClass(true,"Ширина 130 мм",1));

                        break;
                    case R.id.radio6:
                        paramsArray.set(1,new ParamsClass(true,"Ширина 135 мм",1));
                        break;
                    case R.id.radio7:
                        paramsArray.set(1,new ParamsClass(true,"Ширина 140 мм",1));
                        break;
                    case R.id.radio8:
                        paramsArray.set(1,new ParamsClass(true,"Ширина 145 мм",1));

                        break;
                    case R.id.radio9:
                        paramsArray.set(1,new ParamsClass(true,"Ширина 150 мм",1));
                        break;
                    case R.id.radio10:
                        paramsArray.set(1,new ParamsClass(true,"Ширина 155 мм",1));
                        break;
                }
                paramsAdapter.notifyDataSetChanged();
            }
        });

        MainActivity.sesonRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_winter:
                        paramsArray.set(0,new ParamsClass(true,"Зима",0));
                        break;
                    case R.id.radio_summer:
                        paramsArray.set(0,new ParamsClass(true,"Лето",0));

                        break;
                    case R.id.radio_all:
                        paramsArray.set(0,new ParamsClass(true,"Всесезонные",0));
                        break;
                }
                paramsAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    public static void onClickParams(Integer type,Integer pos) {
        switch (type){
            case 0:
                MainActivity.setting_ll.setVisibility(View.GONE);
                MainActivity.seson_ll.setVisibility(View.VISIBLE);
                MainActivity.main_scroll.setForeground(activity.getResources().getDrawable( R.drawable.foreground ));
                break;
            case 1:
                MainActivity.setting_ll.setVisibility(View.GONE);
                MainActivity.seson_ll.setVisibility(View.GONE);
                MainActivity.TP_width.setVisibility(View.VISIBLE);
                MainActivity.main_scroll.setForeground(activity.getResources().getDrawable( R.drawable.foreground ));
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    public static void onClickDeleteParams(Integer type, Integer pos) {
        switch (type){
            case 1:
                paramsArray.set(pos,new ParamsClass(false,"Ширина, мм",1));
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
        paramsAdapter.notifyDataSetChanged();
    }
}
