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

public class FragmentElectronics extends Fragment {

    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public FragmentElectronics() {
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
        itemProduct.setTitle("Microondas 900W");
        itemProduct.setStore("BestBuy");
        itemProduct.setLocation("Zapopan, Jalisco");
        itemProduct.setPhone("3312345678");
        itemProduct.setImage(4);
        itemProduct.setDescription( "Un excelente horno de microondas para que puedas calentar la comida más rápido " +
                                    ". No te quedes sin ver partes de la pelicula por estar haciendo las palomitas");

        itemProductSet.add(itemProduct);

        itemProduct = new ItemProduct();
        itemProduct.setTitle("Lavadora de bateria");
        itemProduct.setStore("Liverpool");
        itemProduct.setLocation("Zapopan, Jalisco");
        itemProduct.setPhone("3346351981");
        itemProduct.setImage(5);
        itemProduct.setDescription( "Carga esta lavadora al máximo y aprovecha su potencial, no vuelvas a desvelarte " +
                                    "hechando las lavadoras, olvidate de la ropa percudia y llena de pelusa");

        itemProductSet.add(itemProduct);
        adapter = new AdapterProduct(getActivity(), itemProductSet);
        recyclerView.setAdapter(adapter);


        return view;
    }
}
