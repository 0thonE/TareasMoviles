package com.iteso.sesion9.beans;


import android.content.SharedPreferences;

import com.iteso.sesion9.tools.Constant;

import static android.app.PendingIntent.getActivity;
import static android.content.Context.MODE_PRIVATE;

public class User {
    private String name, password;
    private boolean isLogged;

    public User(){
    }

    public User(String name, String password, boolean isLogged) {
        this.name = name;
        this.password = password;
        this.isLogged = isLogged;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", isLogged=" + isLogged +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }
}
