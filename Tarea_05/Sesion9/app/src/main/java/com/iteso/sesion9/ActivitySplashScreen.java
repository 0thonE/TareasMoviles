package com.iteso.sesion9;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.iteso.sesion9.beans.City;
import com.iteso.sesion9.beans.Store;
import com.iteso.sesion9.beans.User;
import com.iteso.sesion9.database.DataBaseHandler;
import com.iteso.sesion9.database.StoreControl;
import com.iteso.sesion9.tools.Constant;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplashScreen extends AppCompatActivity {

    public DataBaseHandler dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        dataBase = dataBase.getInstance(getApplicationContext());

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                User user = loadPreferences();

                if(user.isLogged()){
                    //Open ActivityMain
                    Intent intent = new Intent(ActivitySplashScreen.this, ActivityMain.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }else{
                    //Open ActivityLogin
                    Intent intent = new Intent(ActivitySplashScreen.this, ActivityLogin.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 2000);


        ArrayList<Store> stores = new ArrayList<>();
        StoreControl storeControl = new StoreControl();
        stores = storeControl.getStores(DataBaseHandler.getInstance(getApplicationContext()));

        Toast.makeText(this,stores.toString(),Toast.LENGTH_SHORT).show();

        if(stores.size()==0){
            Store store = new Store(1,"BESTBUY", "01 800 237 8289", 0, 20.6489713, -103.4207757, new City(10, "CDMX"));
            stores.add(store);
            store = new Store(2,"RADIOSHACK", "01 800 237 66552", 0, 22.9754, -90.4207757, new City(10, "CDMX"));
            stores.add(store);
            store = new Store(3,"STEREN", "01 800 237 3245", 0, 25.6713, -83.3, new City(10, "CDMX"));
            stores.add(store);
        }



    }

    public User loadPreferences(){
        SharedPreferences sharedPreferences = getSharedPreferences(Constant.USER_PREFERENCES, MODE_PRIVATE);
        User user = new User();
        user.setName(sharedPreferences.getString(Constant.USERNAME, null));
        user.setPassword(sharedPreferences.getString(Constant.PASSWORD, null));
        user.setLogged(sharedPreferences.getBoolean(Constant.LOGGED, false));
        sharedPreferences = null;
        return user;
    }

//    public SQLiteDatabase loadDatabase(){
//        SharedPreferences sharedPreferences = getSharedPreferences(Constant.DATABASE, MODE_PRIVATE);
////        SQLiteDatabase db = new SQLiteDatabase();
////        db.set(sharedPreferences.getBoolean(Constant.LOGGED, false));
////        sharedPreferences = null;
//        return user;
//    }
}
