package com.iteso.sesion9.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iteso.sesion9.beans.City;
import com.iteso.sesion9.beans.Store;
import com.iteso.sesion9.tools.DBConstants;

import java.util.ArrayList;

public class StoreControl {

    public long addStore(Store store, DataBaseHandler dh){
        long rowID = 0;
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBConstants.KEY_STORE_ID, store.getId());
        contentValues.put(DBConstants.KEY_STORE_NAME, store.getName());
        contentValues.put(DBConstants.KEY_STORE_PHONE, store.getPhone());
        contentValues.put(DBConstants.KEY_STORE_THUMBNAIL, store.getThumbnail());
        contentValues.put(DBConstants.KEY_STORE_LAT, store.getLatitude());
        contentValues.put(DBConstants.KEY_STORE_LNG, store.getLongitude());
        contentValues.put(DBConstants.KEY_STORE_CITY, store.getCity().getId());

        rowID = db.insert(DBConstants.TABLE_STORE, null, contentValues);

        try{
            db.close();
        }catch (Exception e){

        }
        db = null;
        contentValues = null;

        return rowID;
    }

    public void deleteStore(int id, DataBaseHandler dh){
        SQLiteDatabase db = dh.getWritableDatabase();
        db.delete(DBConstants.TABLE_STORE,
                DBConstants.KEY_STORE_ID +" = ?",
                new String[]{ String.valueOf(id)});
        try{
            db.close();
        }catch (Exception e){

        }
        db = null;
    }

    public ArrayList<Store> getStores(DataBaseHandler dh){
        SQLiteDatabase db = dh.getReadableDatabase();
        ArrayList<Store> stores = new ArrayList<>();

        String select = "SELECT S." + DBConstants.KEY_STORE_ID +", " + "S." + DBConstants.KEY_STORE_NAME +", "
                                    + "S." + DBConstants.KEY_STORE_PHONE +", " + "S." + DBConstants.KEY_STORE_THUMBNAIL +", "
                                    + "S." + DBConstants.KEY_STORE_LAT +", " + "S." + DBConstants.KEY_STORE_LNG +", "
                                    + "C." + DBConstants.KEY_CITY_ID + "," + "C." + DBConstants.KEY_CITY_NAME
                                    + " FROM " + DBConstants.TABLE_STORE + " S, " + DBConstants.TABLE_CITY + " C "
                                    + "WHERE S." + DBConstants.KEY_STORE_CITY + " = C." + DBConstants.KEY_CITY_ID;

        Cursor cursor = db.rawQuery(select, null);
        while(cursor.moveToNext()){
            Store store = new Store();
            store.setId(cursor.getInt(0));
            store.setName(cursor.getString(1));
            store.setPhone(cursor.getString(2));
            store.setThumbnail(cursor.getInt(3));
            store.setLatitude(cursor.getDouble(4));
            store.setLongitude(cursor.getDouble(5));
            City city = new City();
            city.setId(cursor.getInt(6));
            city.setName(cursor.getString(7));
            store.setCity(city);
            stores.add(store);
        }
        try{
            cursor.close();
            db.close();
        }catch (Exception e){

        }

        db = null;
        cursor = null;

        return stores;
    }

//    public ArrayList<Store> getStoreWhere(String strWhere, String strOrderBy, DataBaseHandler dh){
//        SQLiteDatabase db = dh.getReadableDatabase();
//        ArrayList<Store> itemProducts = new ArrayList<>();
//
//        String select = "SELECT S." + DBConstants.KEY_STORE_ID +", " + "S." + DBConstants.KEY_STORE_NAME +", "
//                + "S." + DBConstants.KEY_PRODUCT_IMAGE +", "
//                + "C." + DBConstants.KEY_CITY_ID + "," + "C." + DBConstants.KEY_CITY_NAME
//                + " FROM " + DBConstants.TABLE_STORE + " S, " + DBConstants.TABLE_CITY + " C "
//                + "WHERE " + strWhere + " ORDER BY " + strOrderBy;
//
//        Cursor cursor = db.rawQuery(select, null);
//        while(cursor.moveToNext()){
//            Store itemProduct = new Store();
//            itemProduct.setCode(cursor.getInt(0));
//            itemProduct.setTitle(cursor.getString(1));
//            itemProduct.setImage(cursor.getInt(2));
//            Category category = new Category();
//            category.setId(cursor.getInt(3));
//            category.setName(cursor.getString(4));
//            itemProduct.setCategory(category);
//            itemProducts.add(itemProduct);
//        }
//        try{
//            cursor.close();
//            db.close();
//        }catch (Exception e){
//
//        }
//
//        db = null;
//        cursor = null;
//
//        return itemProducts;
//    }

    public Store getStoreById(int idStore, DataBaseHandler dh) {
        Store store = new Store();
        String selectQuery = "SELECT   S." + DBConstants.KEY_STORE_ID + "," + "S." + DBConstants.KEY_STORE_LAT + ","
                                    + "S." + DBConstants.KEY_STORE_LNG + "," + "S." + DBConstants.KEY_STORE_NAME + ","
                                    + "S." + DBConstants.KEY_STORE_PHONE + "," + "S." + DBConstants.KEY_STORE_THUMBNAIL + ","
                                    + "C." + DBConstants.KEY_CITY_ID + "," + "C." + DBConstants.KEY_CITY_NAME
                                    + " FROM " + DBConstants.TABLE_STORE + " S, " + DBConstants.TABLE_CITY + " C "
                                    + "WHERE S." + DBConstants.KEY_STORE_ID + "= " + idStore
                                    + " AND S." + DBConstants.KEY_STORE_CITY + " = C." + DBConstants.KEY_CITY_ID;
        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            store.setId(cursor.getInt(0));
            store.setLatitude(cursor.getDouble(1));
            store.setLongitude(cursor.getDouble(2));
            store.setName(cursor.getString(3));
            store.setPhone(cursor.getString(4));
            store.setThumbnail(cursor.getInt(5));
            City city = new City();
            city.setId(cursor.getInt(6));
            city.setName(cursor.getString(7));
            store.setCity(city);
        }
        try {cursor.close();db.close();
        } catch (Exception e) {}
        db = null;
        cursor = null;

        return store;
    }


}
