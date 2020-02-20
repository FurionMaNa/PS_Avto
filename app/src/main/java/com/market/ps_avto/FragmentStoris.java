package com.market.ps_avto;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import static com.market.ps_avto.FragmentTransporClass.activity;

public class FragmentStoris extends Fragment {

    public Integer count;
    public static ArrayList<ProgressBar> progressBar=new ArrayList<ProgressBar>();
    public ConstraintLayout constraintLayout;
    public Random random;
    public Integer num;
    public ImageButton closeBtn;
    public static Thread thread;
    public Integer ii;//История у пользователя
    public Integer jj;//Прогресс истории
    public static FragmentActivity activity;
    public static FragmentManager manager;
    public static LinearLayout ll;
    public View view;
    @SuppressLint("ClickableViewAccessibility")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_storis, container, false);
        random=new Random();
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            num = bundle.getInt("num", 0);
        }
        ii=0;
        jj=0;
        thread=null;
        count= random.nextInt(3)+1;
        ll=view.findViewById(R.id.status_ll_storis);
        ll.removeAllViews();
        constraintLayout=view.findViewById(R.id.main_background_storis);
        progressBar=new ArrayList<ProgressBar>();
        activity= (FragmentActivity)view.getContext();
        manager= activity.getSupportFragmentManager();

        for(int i=0;i<count+1;i++){
            try {
                progressBar.add(new ProgressBar(ll.getContext(), null, android.R.attr.progressBarStyleHorizontal));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f);
                layoutParams.setMargins(5, 0, 5, 0);
                progressBar.get(i).setLayoutParams(layoutParams);
                ll.addView(progressBar.get(i));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        closeBtn=view.findViewById(R.id.close_btn);
        constraintLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int i=ii;
                int x=(int)event.getX();
                int width=v.getWidth();
                if(x>=width/2) {
                    progressBar.get(i).setProgress(100);
                    jj = 95;
                }else{
                    if(i!=0) {
                        progressBar.get(i).setProgress(0);
                        ii--;
                        jj = 0;
                        progressBar.get(i).setProgress(0);
                    }
                }
                return false;
            }
        });
        thread=new Thread(new Runnable() {
            @Override
            public void run() {
                MainActivity.count++;
                try {
                    while (ii < progressBar.size()) {
                        activity.runOnUiThread(new Runnable() {
                            public void run() {
                                constraintLayout.setBackgroundColor(Color.rgb(random.nextInt(255) + 1, random.nextInt(255) + 1, random.nextInt(255) + 1));
                            }
                        });
                        while (jj <= 100) {
                            progressBar.get(ii).setProgress(jj);
                            Thread.sleep(50);
                            jj++;
                        }
                        ii++;
                        jj = 0;
                    }
                    FragmentTransporClass.onStorisEnd(num,thread);
                }catch (InterruptedException  e){
                    Log.i("My","Завершил interrupted");
                }catch (IndexOutOfBoundsException e){
                    Log.i("My","Упал");
                }
                Log.i("My","Завершил");
            }
        });
        thread.start();
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread.interrupt();
                //getActivity().onBackPressed();
                getFragmentManager().beginTransaction().remove(FragmentStoris.this).commit();
                MainActivity.coordinatorLayout.setVisibility(View.VISIBLE);
                MainActivity.main_Scroll.setVisibility(View.VISIBLE);
                MainActivity.ll_storis.setVisibility(View.GONE);
            }
        });
        return view;
    }


}
