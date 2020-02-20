package com.market.ps_avto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentMark extends Fragment {

    public RecyclerView models;
    public ArrayList<String> modelArray= new ArrayList<String>();
    public ModelAdapter modelAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mark, container, false);
        models=view.findViewById(R.id.models);
        MainActivity.type_product.setText("Марки");
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        models.setLayoutManager(layoutManager1);
        modelArray.add("Audi");
        modelArray.add("BMW");
        modelArray.add("Cadilac");
        modelArray.add("Chery");
        modelArray.add("Chevrolet");
        modelArray.add("Citroen");
        modelArray.add("Daewoo");
        modelArray.add("Datsun");
        modelArray.add("Москвич");
        modelArray.add("Жигуль");
        modelArray.add("Ока");
        modelArray.add("Нива");
        modelAdapter= new ModelAdapter(modelArray);
        models.setAdapter(modelAdapter);

        return view;
    }
}
