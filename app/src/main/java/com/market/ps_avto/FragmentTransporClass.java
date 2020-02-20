package com.market.ps_avto;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentTransporClass extends Fragment {

    public Button carsBtn;
    public Button specialCarBtn;
    public Button MotorcycleBtn;
    public static ArrayList<Integer> historyArray=new ArrayList<Integer>();
    public ArrayList<Integer> typeCarsArray=new ArrayList<Integer>();
    public ArrayList<Integer> noNameArray=new ArrayList<Integer>();
    public ArrayList<String> markArray=new ArrayList<String>();
    public ArrayList<String> lastSearchArray=new ArrayList<String>();
    public RecyclerView transportRV;
    public RecyclerView historyRV;
    public MarkAdapter markAdapter;
    public HistoryAdapter historyAdapter;
    public TypeCarsAdapter typeCarsAdapter;
    public NoNameAdapter noNameAdapter;
    public TextBookAdapter textBookAdapter;
    public RecyclerView lastSearchRV;
    public RecyclerView typeCarsRV;
    public RecyclerView noNameRV;
    public RecyclerView textBookRV;
    public LastSearchAdapter lastSearchAdapter;
    public View line1;
    public LinearLayout markAndModel;
    public static FragmentActivity activity;
    public static FragmentManager manager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view   = inflater.inflate(R.layout.fragment_transport, container, false);
        activity= (FragmentActivity)view.getContext();
        manager= activity.getSupportFragmentManager();
        carsBtn=view.findViewById(R.id.cars_btn);
        line1=view.findViewById(R.id.line1);
        markAndModel=view.findViewById(R.id.MarkAndModel);
        specialCarBtn=view.findViewById(R.id.special_cars_btn);
        MotorcycleBtn=view.findViewById(R.id.motorcycle_btn);
        markArray=fillMark(0,markArray);
        historyRV = view.findViewById(R.id.HistoryRecyclerView1);
        transportRV = view.findViewById(R.id.TransportRecyclerView2);
        lastSearchRV = view.findViewById(R.id.lastSearchRecyclerView);
        typeCarsRV = view.findViewById(R.id.carsRecyclerView);
        noNameRV = view.findViewById(R.id.RecyclerView3);
        textBookRV=view.findViewById(R.id.TextBookRecyclerView);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        for(int i=0;i<4;i++){ historyArray.add(i); }
        for(int i=0;i<3;i++){ typeCarsArray.add(i); }
        for(int i=0;i<2;i++){ noNameArray.add(i); }
        for(int i=0;i<4;i++){ lastSearchArray.add(String.valueOf(i)); }
        historyRV.setLayoutManager(layoutManager1);
        historyAdapter = new HistoryAdapter(historyArray);
        historyRV.setAdapter(historyAdapter);

        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        transportRV.setLayoutManager(layoutManager2);
        markAdapter= new MarkAdapter(markArray);
        transportRV.setAdapter(markAdapter);

        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        lastSearchRV.setLayoutManager(layoutManager3);
        lastSearchAdapter= new LastSearchAdapter(lastSearchArray);
        lastSearchRV.setAdapter(lastSearchAdapter);

        RecyclerView.LayoutManager layoutManager4 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        typeCarsRV.setLayoutManager(layoutManager4);
        typeCarsAdapter= new TypeCarsAdapter(typeCarsArray);
        typeCarsRV.setAdapter(typeCarsAdapter);

        RecyclerView.LayoutManager layoutManager5 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        noNameRV.setLayoutManager(layoutManager5);
        noNameAdapter= new NoNameAdapter(noNameArray);
        noNameRV.setAdapter(noNameAdapter);

        RecyclerView.LayoutManager layoutManager6 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        textBookRV.setLayoutManager(layoutManager6);
        textBookAdapter= new TextBookAdapter(noNameArray);
        textBookRV.setAdapter(textBookAdapter);

        carsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carsBtn.setBackgroundResource(R.drawable.left_type_btn_select);
                carsBtn.setTextColor(Color.WHITE);
                specialCarBtn.setBackgroundResource(R.drawable.main_type_btn_no_select);
                specialCarBtn.setTextColor(Color.parseColor("#B4B4B4"));
                MotorcycleBtn.setBackgroundResource(R.drawable.right_type_btn_no_select);
                MotorcycleBtn.setTextColor(Color.parseColor("#B4B4B4"));
                markArray.clear();
                markArray=fillMark(0,markArray);
                markAdapter.notifyDataSetChanged();
                line1.setVisibility(View.VISIBLE);
                markAndModel.setVisibility(View.VISIBLE);
                typeCarsRV.setVisibility(View.VISIBLE);
            }
        });
        specialCarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carsBtn.setBackgroundResource(R.drawable.left_type_btn_no_select);
                carsBtn.setTextColor(Color.parseColor("#B4B4B4"));
                specialCarBtn.setBackgroundResource(R.drawable.main_type_btn_select);
                specialCarBtn.setTextColor(Color.WHITE);
                MotorcycleBtn.setBackgroundResource(R.drawable.right_type_btn_no_select);
                MotorcycleBtn.setTextColor(Color.parseColor("#B4B4B4"));
                markArray.clear();
                markArray=fillMark(1,markArray);
                markAdapter.notifyDataSetChanged();
                line1.setVisibility(View.GONE);
                markAndModel.setVisibility(View.GONE);
                typeCarsRV.setVisibility(View.GONE);
            }
        });
        MotorcycleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carsBtn.setBackgroundResource(R.drawable.left_type_btn_no_select);
                carsBtn.setTextColor(Color.parseColor("#B4B4B4"));
                specialCarBtn.setBackgroundResource(R.drawable.main_type_btn_no_select);
                specialCarBtn.setTextColor(Color.parseColor("#B4B4B4"));
                MotorcycleBtn.setBackgroundResource(R.drawable.right_type_btn_select);
                MotorcycleBtn.setTextColor(Color.WHITE);
                markArray.clear();
                markArray=fillMark(2,markArray);
                markAdapter.notifyDataSetChanged();
                line1.setVisibility(View.GONE);
                markAndModel.setVisibility(View.GONE);
                typeCarsRV.setVisibility(View.GONE);
            }
        });
        return view;
    }

    private ArrayList<String> fillMark(int type, ArrayList<String> mark){
        switch (type){
            case 0:
                mark.add("Audi");
                mark.add("BMW");
                mark.add("Mercedes-Benz");
                mark.add("Volkswagen");
                break;
            case 1:
                mark.add("Микроавтобусы");
                mark.add("Грузовики");
                mark.add("Седельные тягачи");
                break;
            case 2:
                mark.add("Мотоциклы");
                mark.add("Скутеры");
                mark.add("Квадроциклы");
                break;
        }
        return mark;
    }


    public static void onClickStoris(View v,Integer pos) {
        FragmentStoris fragment= new FragmentStoris();
        Bundle args = new Bundle();
        args.putInt("num", pos);
        fragment.setArguments(args);
        MainActivity.coordinatorLayout.setVisibility(View.GONE);
        MainActivity.main_Scroll.setVisibility(View.GONE);
        MainActivity.ll_storis.setVisibility(View.VISIBLE);
        manager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.storis_panel,fragment  ).addToBackStack(null).commit();
    }

    public static void onStorisEnd(Integer num,Thread thread) {
        if(num<historyArray.size()-1) {
            num++;
            thread.interrupt();
            FragmentStoris fragment = new FragmentStoris();
            Bundle args = new Bundle();
            args.putInt("num", num);
            fragment.setArguments(args);
            manager.beginTransaction().setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left, R.animator.enter_from_left, R.animator.exit_to_right).replace(R.id.storis_panel,fragment).commit();
        }else{
            activity.runOnUiThread(new Runnable(){
                public void run(){
                    MainActivity.coordinatorLayout.setVisibility(View.VISIBLE);
                    MainActivity.main_Scroll.setVisibility(View.VISIBLE);
                    MainActivity.ll_storis.setVisibility(View.GONE);
                }
            });
        }
    }

    public static void onClickMark(View v) {
        MainActivity.clMainToolBar.setVisibility(View.GONE);
        MainActivity.clAllToolBar.setVisibility(View.VISIBLE);
        MainActivity.setting_ll.setVisibility(View.VISIBLE);
        Bundle args = new Bundle();
        args.putString("model", v.getTag().toString());
        FragmentAds fragment=new FragmentAds();
        fragment.setArguments(args);
        MainActivity.tagFragment.add("FragmentAds");
        manager.beginTransaction().add(R.id.nav_host_fragment,fragment,"FragmentAds" ).show(fragment).hide(manager.findFragmentByTag("fragmentTransportClass")).addToBackStack(null).commit();
    }

}
