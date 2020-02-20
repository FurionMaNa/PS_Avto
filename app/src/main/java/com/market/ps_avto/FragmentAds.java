package com.market.ps_avto;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentAds  extends Fragment {

    public RecyclerView imageRV;
    public ImageCarAdapter imageCarAdapter;
    public ArrayList<Integer> imageArray=new ArrayList<Integer>();
    public AlertDialog.Builder ad;
    public LinearLayout ll_moreInfo;
    public boolean[] mCheckedItems = { false };
    public String model;
    public TextView name_model;
    public LinearLayout ads;
    public static FragmentActivity activity;
    public static FragmentManager manager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ads, container, false);
        activity= (FragmentActivity)view.getContext();
        manager= activity.getSupportFragmentManager();
        imageRV=view.findViewById(R.id.car_photo);
        ll_moreInfo=view.findViewById(R.id.ll_moreInfo);
        name_model=view.findViewById(R.id.name_model);
        ads=view.findViewById(R.id.linearLayout2);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            model = bundle.getString("model", "");
        }
        name_model.setText(model);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        imageRV.setLayoutManager(layoutManager1);
        imageArray.add(0);
        imageArray.add(1);
        imageCarAdapter= new ImageCarAdapter(imageArray);
        imageRV.setAdapter(imageCarAdapter);
        ads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.clMainToolBar.setVisibility(View.GONE);
                MainActivity.clAllToolBar.setVisibility(View.GONE);
                MainActivity.clMoreAdsToolBar.setVisibility(View.VISIBLE);
                MainActivity.setting_ll.setVisibility(View.GONE);
                MainActivity.tagFragment.add("MoreAdsFragment");
                FragmentMoreAds fragment=new FragmentMoreAds();
                manager.beginTransaction().add(R.id.nav_host_fragment,fragment,"MoreAdsFragment" ).show(fragment).hide(manager.findFragmentByTag("FragmentAds")).addToBackStack(null).commit();
            }
        });
        MainActivity.setting_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ad = new AlertDialog.Builder(getContext());
                final String[] checkParametrs = { "Показать полные объявления"};
                ad.setTitle("Выберите нужные параметры")
                        .setCancelable(false)
                        .setMultiChoiceItems(checkParametrs, mCheckedItems,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which, boolean isChecked) {
                                        mCheckedItems[which] = isChecked;
                                    }
                                })
                        .setPositiveButton("Ок",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        StringBuilder state = new StringBuilder();
                                        for (int i = 0; i < checkParametrs.length; i++) {
                                            if (mCheckedItems[i])
                                                ll_moreInfo.setVisibility(View.VISIBLE);
                                            else
                                                ll_moreInfo.setVisibility(View.GONE);
                                        }
                                    }
                                });

                ad.show();
            }
        });

        return view;
    }
}
