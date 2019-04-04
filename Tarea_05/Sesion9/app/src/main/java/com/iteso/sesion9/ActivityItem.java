package com.iteso.sesion9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.iteso.sesion9.beans.Category;
import com.iteso.sesion9.beans.ItemProduct;
import com.iteso.sesion9.beans.Store;
import com.iteso.sesion9.database.CategoryControl;
import com.iteso.sesion9.database.DataBaseHandler;
import com.iteso.sesion9.database.ItemProductControl;
import com.iteso.sesion9.database.StoreControl;

import java.util.ArrayList;

public class ActivityItem extends AppCompatActivity {

    Spinner images, stores, categories;
    EditText title;
    Button save;
    CategoryControl categoryControl;
    StoreControl storeControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        images = findViewById(R.id.activity_item_img_spinner);
        stores = findViewById(R.id.activity_item_stores_spinner);
        categories = findViewById(R.id.activity_item_stores_spinner);
        title = findViewById(R.id.activity_item_title);
        save = findViewById(R.id.activity_item_save);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.images_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        images.setAdapter(adapter);

        //DataBase Objects
        DataBaseHandler dh = DataBaseHandler.getInstance(getApplicationContext());
        StoreControl storeControl = new StoreControl();
        CategoryControl categoryControl = new CategoryControl();

        ArrayList<Store> storesList = storeControl.getStores(dh);
        ArrayList<Category> categoriesList = categoryControl.getCategories(dh);
//Create Adapter to show into Spinner, ListView or GridLayout
        ArrayAdapter<Store> storesAdapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, storesList);
        stores.setAdapter(storesAdapter);
        ArrayAdapter<Category>categoriesAdapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categoriesList);
        categories.setAdapter(categoriesAdapter);


        title.setText(storeControl.getStoreById(1, dh).toString());


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                CategoryControl categoryControl = new CategoryControl();
//                ItemProduct itemProduct = new ItemProduct();
//                itemProduct.setTitle(title.getText().toString());
//                itemProduct.setImage(images.getSelectedItemPosition());
//                itemProduct.setCategory(categoryControl.getCategoryById(categories.getSelectedItemPosition(), DataBaseHandler.getInstance(getApplicationContext())));
//
//                ItemProductControl itemProductControl = new ItemProductControl();
//                itemProductControl.addItemProduct(itemProduct, DataBaseHandler.getInstance(getApplicationContext()));

//                title.setText(Integer.toString(images.getSelectedItemPosition()));

            }
        });

    }
}
