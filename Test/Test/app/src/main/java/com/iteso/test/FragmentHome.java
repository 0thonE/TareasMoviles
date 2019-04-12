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

public class FragmentHome extends Fragment {
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public FragmentHome() {
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_main_recycler_view);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<ItemProduct> itemProductSet = new ArrayList<>();
        ItemProduct itemProduct = new ItemProduct();
        itemProduct.setTitle("Asador 300");
        itemProduct.setStore("HomeDepot");
        itemProduct.setLocation("Zapopan, Jalisco");
        itemProduct.setPhone("3316672854");
        itemProduct.setImage(2);
        itemProduct.setDescription( "Llevate uns asador para esas parrilladas que tanto deseas disfrutar" +
                                    ", solo este mes llevatelo con accesorios totalmente gratis");

        itemProductSet.add(itemProduct);

        itemProduct = new ItemProduct();
        itemProduct.setTitle("Sillon Reclinable");
        itemProduct.setStore("BestBuy");
        itemProduct.setLocation("Zapopan, Jalisco");
        itemProduct.setPhone("3312345678");
        itemProduct.setImage(3);
        itemProduct.setDescription( "Llevate esta sillon reclinable y llevate 1 blue-ray de tu elección " +
                                    " para que disfrutes en casita como debe ser");

        itemProductSet.add(itemProduct);
        adapter = new AdapterProduct(getActivity(), itemProductSet);
        recyclerView.setAdapter(adapter);


        return view;

    }
}
