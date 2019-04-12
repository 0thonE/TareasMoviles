package com.iteso.test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.test.beans.ItemProduct;

import java.util.ArrayList;

public class FragmentTechnology extends Fragment {
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    public FragmentTechnology() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_main_recycler_view);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<ItemProduct> itemProductSet = new ArrayList<>();
        ItemProduct itemProduct = new ItemProduct();
        itemProduct.setTitle("MacBook Pro 17\"");
        itemProduct.setStore("BestBuy");
        itemProduct.setLocation("Zapopan, Jalisco");
        itemProduct.setPhone("3312345678");
        itemProduct.setImage(0);
        itemProduct.setDescription( "Llevate esta Mac con un 30% de descuento para que puedas programar " +
                "para XCode y Android sin tener que batallar tanto como en tu Windows");

        itemProductSet.add(itemProduct);

        itemProduct = new ItemProduct();
        itemProduct.setTitle("Alienware S 17.5\"");
        itemProduct.setStore("BestBuy");
        itemProduct.setLocation("Zapopan, Jalisco");
        itemProduct.setPhone("3312345678");
        itemProduct.setImage(1);
        itemProduct.setDescription( "Llevate esta Mac con un 15% de descuento para que puedas programar " +
                                    "Android sin tener que batallar con la lentidud de otras computadoras");

        itemProductSet.add(itemProduct);
        adapter = new AdapterProduct(getActivity(), itemProductSet);
        recyclerView.setAdapter(adapter);


        return view;
    }
}
