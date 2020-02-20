package com.market.ps_avto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class FragmentSparesClass extends Fragment {

    public LinearLayout bracke;
    public LinearLayout tire;
    public LinearLayout battery;
    public LinearLayout oil;
    public LinearLayout chassis;
    public LinearLayout appointment;
    public LinearLayout MarkAndModel;
    public static FragmentActivity activity;
    public static FragmentManager manager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spares, container, false);
        activity= (FragmentActivity)view.getContext();
        manager= activity.getSupportFragmentManager();
        bracke =view.findViewById(R.id.bracke);
        tire=view.findViewById(R.id.tire);
        battery=view.findViewById(R.id.battery);
        oil=view.findViewById(R.id.oil);
        chassis=view.findViewById(R.id.chassis);
        appointment=view.findViewById(R.id.appointment);
        MarkAndModel=view.findViewById(R.id.MarkAndModel);
        MarkAndModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.tagFragment.add("markFragment");
                FragmentMark fragment=new FragmentMark();
                MainActivity.setting_ll.setVisibility(View.GONE);
                MainActivity.clMainToolBar.setVisibility(View.GONE);
                MainActivity.clProductToolBar.setVisibility(View.VISIBLE);
                MainActivity.setting_ll.setVisibility(View.VISIBLE);
                manager.beginTransaction().add(R.id.nav_host_fragment,fragment,"markFragment" ).show(fragment).hide(manager.findFragmentByTag("fragmentSparesClass")).addToBackStack(null).commit();
            }
        });
        bracke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.tagFragment.add("FragmentSparesTypeClass");
                Bundle args = new Bundle();
                args.putInt("type", 0);
                FragmentSparesTypeClass fragment=new FragmentSparesTypeClass();
                fragment.setArguments(args);
                manager.beginTransaction().add(R.id.nav_host_fragment,fragment,"FragmentSparesTypeClass" ).show(fragment).hide(manager.findFragmentByTag("fragmentSparesClass")).addToBackStack(null).commit();
            }
        });
        tire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.tagFragment.add("FragmentTireRims");
                FragmentTireRims fragment=new FragmentTireRims();
                manager.beginTransaction().add(R.id.nav_host_fragment,fragment,"FragmentTireRims" ).show(fragment).hide(manager.findFragmentByTag("fragmentSparesClass")).addToBackStack(null).commit();
            }
        });
        battery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.tagFragment.add("FragmentSparesTypeClass");
                Bundle args = new Bundle();
                args.putInt("type", 2);
                FragmentSparesTypeClass fragment=new FragmentSparesTypeClass();
                fragment.setArguments(args);
                manager.beginTransaction().add(R.id.nav_host_fragment,fragment,"FragmentSparesTypeClass" ).show(fragment).hide(manager.findFragmentByTag("fragmentSparesClass")).addToBackStack(null).commit();
            }
        });
        oil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.tagFragment.add("FragmentSparesTypeClass");
                Bundle args = new Bundle();
                args.putInt("type", 3);
                FragmentSparesTypeClass fragment=new FragmentSparesTypeClass();
                fragment.setArguments(args);
                manager.beginTransaction().add(R.id.nav_host_fragment,fragment,"FragmentSparesTypeClass" ).show(fragment).hide(manager.findFragmentByTag("fragmentSparesClass")).addToBackStack(null).commit();
            }
        });
        chassis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.tagFragment.add("FragmentSparesTypeClass");
                Bundle args = new Bundle();
                args.putInt("type", 4);
                FragmentSparesTypeClass fragment=new FragmentSparesTypeClass();
                fragment.setArguments(args);
                manager.beginTransaction().add(R.id.nav_host_fragment,fragment,"FragmentSparesTypeClass" ).show(fragment).hide(manager.findFragmentByTag("fragmentSparesClass")).addToBackStack(null).commit();
            }
        });
        appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.tagFragment.add("FragmentSparesTypeClass");
                Bundle args = new Bundle();
                args.putInt("type", 5);
                FragmentSparesTypeClass fragment=new FragmentSparesTypeClass();
                fragment.setArguments(args);
                manager.beginTransaction().add(R.id.nav_host_fragment,fragment,"FragmentSparesTypeClass" ).show(fragment).hide(manager.findFragmentByTag("fragmentSparesClass")).addToBackStack(null).commit();
            }
        });
        return view;
    }
}
