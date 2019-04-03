package com.iteso.sesion9;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iteso.sesion9.beans.User;
import com.iteso.sesion9.tools.Constant;

import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                User user = loadPreferences();

                if(user.isLogged()){
                    //Open ActivityMain
                    Intent intent = new Intent(ActivitySplashScreen.this, MainActivity.class);
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
}
