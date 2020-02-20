package com.market.ps_avto;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentSparesTypeClass extends Fragment {

    public Integer type;
    public FlexboxLayout flexboxLayout;
    public ArrayAdapter<String> adapter;
    public Button more;
    public Boolean moreFlag;
    public RecyclerView tag;
    public ArrayList<String> nameTag=new ArrayList<String >();
    public TagAdapter tagAdapter;
    public LinearLayout markAndModel;
    public static FragmentActivity activity;
    public static FragmentManager manager;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spares_type, container, false);
        activity= (FragmentActivity)view.getContext();
        manager= activity.getSupportFragmentManager();
        MainActivity.clMainToolBar.setVisibility(View.GONE);
        MainActivity.clProductToolBar.setVisibility(View.VISIBLE);
        MainActivity.setting_ll.setVisibility(View.VISIBLE);
        flexboxLayout=view.findViewById(R.id.type);
        tag=view.findViewById(R.id.tag);
        more=view.findViewById(R.id.more);
        markAndModel=view.findViewById(R.id.MarkAndModel);
        moreFlag=false;
        MainActivity.type_product.setText("");
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            type = bundle.getInt("type", 0);
        }
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        tag.setLayoutManager(layoutManager1);
        nameTag.add("LRD4-000117");
        nameTag.add("Land Rover");
        nameTag.add("Новый");
        nameTag.add("В наличии");
        nameTag.add("100x100");
        nameTag.add("Металл");
        tagAdapter= new TagAdapter(nameTag);
        tag.setAdapter(tagAdapter);

        switch (type){
            case 0:
                String[] data={"Аксессуары для салона","Перевозка багажа","Автоэлектроника","Дополнительные аксесуары","Уход за автомобилем","Дополнительное оборудование","Аудио","Запчасти","Покрышки","Аудио","Запчасти","Покрышки","Аудио","Запчасти","Покрышки"};
                flexboxLayout.setFlexDirection(FlexDirection.ROW);
                for(int i=0;i<data.length;i++){
                    LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.setMargins(0,10,30,10);
                    TextView textView=new TextView(flexboxLayout.getContext());
                    textView.setLayoutParams(layoutParams);
                    textView.setText(data[i]);
                    textView.setClickable(true);
                    textView.setBackgroundResource(R.drawable.white_panel);
                    textView.setTextColor(Color.BLACK);
                    textView.setTextSize(16);
                    textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                    textView.setPadding(30,20,30,20);
                    flexboxLayout.addView(textView);
                }
                View v = flexboxLayout.getChildAt(0);
                FlexboxLayout.LayoutParams lp = (FlexboxLayout.LayoutParams) v.getLayoutParams();
                v.setLayoutParams(lp);
                break;
            default:
                String[] datas={"Коврики","Чехлы на автомобильные седенья","Ароматизаторы","Оплётки на руль","Шторки на окна","Держатели и подстаканники","Аудио","Запчасти","Покрышки","Аудио","Запчасти","Покрышки","Аудио","Запчасти","Покрышки","Аудио","Запчасти","Покрышки"};
                flexboxLayout.setFlexDirection(FlexDirection.ROW);
                for(int i=0;i<datas.length;i++){
                    LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.setMargins(0,10,30,10);
                    TextView textView=new TextView(flexboxLayout.getContext());
                    textView.setLayoutParams(layoutParams);
                    textView.setText(datas[i]);
                    textView.setClickable(true);
                    textView.setBackgroundResource(R.drawable.white_panel);
                    textView.setTextColor(Color.BLACK);
                    textView.setTextSize(16);
                    textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                    textView.setPadding(30,20,30,20);
                    flexboxLayout.addView(textView);
                }
                View v1 = flexboxLayout.getChildAt(0);
                FlexboxLayout.LayoutParams lp1 = (FlexboxLayout.LayoutParams) v1.getLayoutParams();
                v1.setLayoutParams(lp1);
                break;
        }
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final float scale = getResources().getDisplayMetrics().density;
                if(moreFlag){
                    more.setText("Ещё");
                    LinearLayout.LayoutParams linear=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,271);
                    flexboxLayout.setLayoutParams(linear);

                }else{
                    more.setText("Меньше");
                    LinearLayout.LayoutParams linear=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    flexboxLayout.setLayoutParams(linear);
                }
                moreFlag=!moreFlag;
            }
        });
        markAndModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.tagFragment.add("markFragment");
                FragmentMark fragment=new FragmentMark();
                MainActivity.setting_ll.setVisibility(View.GONE);
                manager.beginTransaction().add(R.id.nav_host_fragment,fragment,"markFragment" ).show(fragment).hide(manager.findFragmentByTag("FragmentSparesTypeClass")).addToBackStack(null).commit();
            }
        });
        return view;
    }
}
