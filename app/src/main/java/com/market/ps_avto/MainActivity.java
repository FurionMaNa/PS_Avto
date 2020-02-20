package com.market.ps_avto;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    public static ScrollView main_Scroll;
    public static CoordinatorLayout coordinatorLayout;
    public static LinearLayout ll_storis;
    public static ConstraintLayout clMainToolBar;
    public static ConstraintLayout clAllToolBar;
    public static ConstraintLayout clMoreAdsToolBar;
    public static ConstraintLayout clProductToolBar;
    public static LinearLayout setting_ll;
    public static LinearLayout seson_ll;
    public static LinearLayout TP_width;
    public static ArrayList<String> tagFragment=new ArrayList<String>();
    public Button backBtn;
    public Button backBtn_ads;
    public Button backBtn_product;
    public LinearLayout menu_btn_ads;
    public static LinearLayout TP_Price;
    public ImageButton close;
    public ImageButton close_sesons;
    public ImageButton close_width;
    public static ScrollView main_scroll;
    public static TextView type_product;
    public static Context context;
    public static RadioGroup sesonRadioGroup;
    public static RadioGroup widthRadioGroup;
    public LinearLayout main_image;
    public ConstraintLayout main;
    public static int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main = findViewById(R.id.main);
        count=0;
        main_image=findViewById(R.id.main_image);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MainActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        main_image.setVisibility(View.INVISIBLE);
                        main_image.setVisibility(View.GONE);
                        main.setVisibility(View.VISIBLE);
                    }
                });
            }
        }).start();
        context=MainActivity.this;
        toolbar = findViewById(R.id.toolbar);
        main_Scroll=findViewById(R.id.main_Scroll);
        coordinatorLayout=findViewById(R.id.BottomMenu);
        ll_storis=findViewById(R.id.ll_storis);
        clMainToolBar=findViewById(R.id.CLMainToolBar);
        clAllToolBar=findViewById(R.id.CLAllToolBar);
        clMoreAdsToolBar=findViewById(R.id.CLAdsMoreToolBar);
        clProductToolBar=findViewById(R.id.CLProductToolBar);
        setting_ll=findViewById(R.id.setting_ll);
        backBtn=findViewById(R.id.backBtn);
        backBtn_ads=findViewById(R.id.backBtn_ads);
        menu_btn_ads=findViewById(R.id.menu_btn_ads);
        TP_Price=findViewById(R.id.TP_Price);
        close=findViewById(R.id.close_price);
        main_scroll=findViewById(R.id.main_Scroll);
        backBtn_product=findViewById(R.id.backBtn_product);
        type_product=findViewById(R.id.type_product);
        seson_ll=findViewById(R.id.TP_Seson);
        close_sesons=findViewById(R.id.close_sesons);
        sesonRadioGroup=findViewById(R.id.SesonradioGroup);
        close_width=findViewById(R.id.close_width);
        TP_width=findViewById(R.id.TP_width);
        widthRadioGroup=findViewById(R.id.WidthradioGroup);
        setSupportActionBar(toolbar);
        tagFragment.add("fragmentTransportClass");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment,  new FragmentTransporClass(),"fragmentTransportClass").addToBackStack(null).commit();
        close_width.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.setting_ll.setVisibility(View.VISIBLE);
                MainActivity.seson_ll.setVisibility(View.GONE);
                main_scroll.setForeground(getResources().getDrawable( R.drawable.foreground_no ));
                TP_width.setVisibility(View.GONE);
            }
        });
        backBtn_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().show(getSupportFragmentManager().findFragmentByTag(tagFragment.get(tagFragment.size()-2))).remove(getSupportFragmentManager().findFragmentByTag(tagFragment.get(tagFragment.size()-1))).commit();
                if((tagFragment.get(tagFragment.size()-2).equals("fragmentTransportClass"))||(tagFragment.get(tagFragment.size()-2).equals("fragmentSparesClass"))){
                    clMainToolBar.setVisibility(View.VISIBLE);
                    clAllToolBar.setVisibility(View.GONE);
                    clProductToolBar.setVisibility(View.GONE);
                    setting_ll.setVisibility(View.GONE);
                }
                seson_ll.setVisibility(View.GONE);
                TP_width.setVisibility(View.GONE);
                main_scroll.setForeground(getResources().getDrawable( R.drawable.foreground_no ));
                tagFragment.remove(tagFragment.size()-1);
                type_product.setText("");
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().show(getSupportFragmentManager().findFragmentByTag(tagFragment.get(tagFragment.size()-2))).remove(getSupportFragmentManager().findFragmentByTag(tagFragment.get(tagFragment.size()-1))).commit();
                if((tagFragment.get(tagFragment.size()-2).equals("fragmentTransportClass"))||(tagFragment.get(tagFragment.size()-2).equals("fragmentSparesClass"))){
                    clMainToolBar.setVisibility(View.VISIBLE);
                    clAllToolBar.setVisibility(View.GONE);
                    clProductToolBar.setVisibility(View.GONE);
                    setting_ll.setVisibility(View.GONE);
                }
                tagFragment.remove(tagFragment.size()-1);
            }
        });
        backBtn_ads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().show(getSupportFragmentManager().findFragmentByTag(tagFragment.get(tagFragment.size()-2))).remove(getSupportFragmentManager().findFragmentByTag(tagFragment.get(tagFragment.size()-1))).commit();
                clAllToolBar.setVisibility(View.VISIBLE);
                setting_ll.setVisibility(View.VISIBLE);
                clMoreAdsToolBar.setVisibility(View.GONE);
                clProductToolBar.setVisibility(View.GONE);
                TP_Price.setVisibility(View.GONE);
                main_scroll.setForeground(getResources().getDrawable( R.drawable.foreground_no ));
                tagFragment.remove(tagFragment.size()-1);
            }
        });
        menu_btn_ads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pm = new PopupMenu(MainActivity.this, v);
                pm.getMenuInflater().inflate(R.menu.ads_menu, pm.getMenu());
                pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        return true;
                    }
                });
                pm.show();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.TP_Price.setVisibility(View.GONE);
                main_scroll.setForeground(getResources().getDrawable( R.drawable.foreground_no ));
            }
        });
        close_sesons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.setting_ll.setVisibility(View.VISIBLE);
                MainActivity.seson_ll.setVisibility(View.GONE);
                main_scroll.setForeground(getResources().getDrawable( R.drawable.foreground_no ));
                TP_width.setVisibility(View.GONE);
            }
        });
    }

    public void onClickToolBarMenu(View v){
        switch (v.getId()){
            case R.id.transportBtn:
                tagFragment.add("fragmentTransportClass");
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment,  new FragmentTransporClass(),"fragmentTransportClass").addToBackStack(null).commit();
                v.setBackgroundResource(R.drawable.top_select_button);
                ((Button)findViewById(R.id.sparesBtn)).setBackgroundResource(R.drawable.top_no_select_button);
                ((Button)findViewById(R.id.servicesBtn)).setBackgroundResource(R.drawable.top_no_select_button);
                break;
            case R.id.sparesBtn:
                tagFragment.add("fragmentSparesClass");
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment,  new FragmentSparesClass(),"fragmentSparesClass").addToBackStack(null).commit();
                v.setBackgroundResource(R.drawable.top_select_button);
                ((Button)findViewById(R.id.transportBtn)).setBackgroundResource(R.drawable.top_no_select_button);
                ((Button)findViewById(R.id.servicesBtn)).setBackgroundResource(R.drawable.top_no_select_button);
                break;
            case R.id.servicesBtn:
                v.setBackgroundResource(R.drawable.top_select_button);
                ((Button)findViewById(R.id.transportBtn)).setBackgroundResource(R.drawable.top_no_select_button);
                ((Button)findViewById(R.id.sparesBtn)).setBackgroundResource(R.drawable.top_no_select_button);
                break;
        }
    }


}
