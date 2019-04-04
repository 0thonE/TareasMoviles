package com.iteso.sesion9.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iteso.sesion9.beans.Category;
import com.iteso.sesion9.beans.ItemProduct;
import com.iteso.sesion9.tools.DBConstants;

import java.util.ArrayList;

public class ItemProductControl {

    public long addItemProduct(ItemProduct itemProduct, DataBaseHandler dh){
        long rowID = 0;
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBConstants.KEY_PRODUCT_ID, itemProduct.getCode());
        contentValues.put(DBConstants.KEY_PRODUCT_TITLE, itemProduct.getTitle());
        contentValues.put(DBConstants.KEY_PRODUCT_IMAGE, itemProduct.getImage());
        contentValues.put(DBConstants.KEY_PRODUCT_CATEGORY, itemProduct.getCategory().getId());

        rowID = db.insert(DBConstants.TABLE_PRODUCT, null, contentValues);

        try{
            db.close();
        }catch (Exception e){

        }
        db = null;
        contentValues = null;

        return rowID;
    }

    public void deleteItemProduct(int id, DataBaseHandler dh){
        SQLiteDatabase db = dh.getWritableDatabase();
        db.delete(DBConstants.TABLE_PRODUCT,
                DBConstants.KEY_PRODUCT_ID +" = ?",
                new String[]{ String.valueOf(id)});
        try{
            db.close();
        }catch (Exception e){

        }
        db = null;
    }

    public ArrayList<ItemProduct> getItemProduct(DataBaseHandler dh){
        SQLiteDatabase db = dh.getReadableDatabase();
        ArrayList<ItemProduct> itemProducts = new ArrayList<>();

        String select = "SELECT P." + DBConstants.KEY_PRODUCT_ID +", " + "P." + DBConstants.KEY_PRODUCT_TITLE +", "
                                    + "P." + DBConstants.KEY_PRODUCT_IMAGE +", "
                                    + "C." + DBConstants.KEY_CATEGORY_ID + "," + "C." + DBConstants.KEY_CATEGORY_NAME
                                    + " FROM " + DBConstants.TABLE_PRODUCT + " P, " + DBConstants.TABLE_CATEGORY + " C "
                                    + "WHERE P." + DBConstants.KEY_PRODUCT_CATEGORY + " = C." + DBConstants.KEY_CATEGORY_ID;

        Cursor cursor = db.rawQuery(select, null);
        while(cursor.moveToNext()){
            ItemProduct itemProduct = new ItemProduct();
            itemProduct.setCode(cursor.getInt(0));
            itemProduct.setTitle(cursor.getString(1));
            itemProduct.setImage(cursor.getInt(2));
            Category category = new Category();
            category.setId(cursor.getInt(3));
            category.setName(cursor.getString(4));
            itemProduct.setCategory(category);
            itemProducts.add(itemProduct);
        }
        try{
            cursor.close();
            db.close();
        }catch (Exception e){

        }

        db = null;
        cursor = null;

        return itemProducts;
    }

    public ArrayList<ItemProduct> getItemProductByCategory(int idCategory, DataBaseHandler dh) {
        ItemProduct itemProduct = new ItemProduct();
        ArrayList<ItemProduct> itemProducts = new ArrayList<>();

        String selectQuery = "SELECT   P."  + DBConstants.KEY_PRODUCT_ID +", " + "P." + DBConstants.KEY_PRODUCT_TITLE +", "
                + "P." + DBConstants.KEY_PRODUCT_IMAGE +", "
                + "C." + DBConstants.KEY_CATEGORY_ID + "," + "C." + DBConstants.KEY_CATEGORY_NAME
                + " FROM " + DBConstants.TABLE_PRODUCT + " P, " + DBConstants.TABLE_CATEGORY + " C "
                + "WHERE P." + DBConstants.KEY_PRODUCT_CATEGORY + "= " + idCategory
                + " AND P." + DBConstants.KEY_PRODUCT_CATEGORY + " = C." + DBConstants.KEY_CATEGORY_ID;
        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        while(cursor.moveToNext()){
            itemProduct.setCode(cursor.getInt(0));
            itemProduct.setTitle(cursor.getString(1));
            itemProduct.setImage(cursor.getInt(2));
            Category category = new Category();
            category.setId(cursor.getInt(3));
            category.setName(cursor.getString(4));
            itemProduct.setCategory(category);
        }
        try {cursor.close();db.close();
        } catch (Exception e) {}
        db = null;
        cursor = null;

        return itemProducts;
    }

    public ArrayList<ItemProduct> getItemProductsWhere(String strWhere, String strOrderBy, DataBaseHandler dh){
        SQLiteDatabase db = dh.getReadableDatabase();
        ArrayList<ItemProduct> itemProducts = new ArrayList<>();

        String select = "SELECT P." + DBConstants.KEY_PRODUCT_ID +", " + "P." + DBConstants.KEY_PRODUCT_TITLE +", "
                + "P." + DBConstants.KEY_PRODUCT_IMAGE +", "
                + "C." + DBConstants.KEY_CATEGORY_ID + "," + "C." + DBConstants.KEY_CATEGORY_NAME
                + " FROM " + DBConstants.TABLE_PRODUCT + " P, " + DBConstants.TABLE_CATEGORY + " C "
                + "WHERE " + strWhere + " ORDER BY " + strOrderBy;

        Cursor cursor = db.rawQuery(select, null);
        while(cursor.moveToNext()){
            ItemProduct itemProduct = new ItemProduct();
            itemProduct.setCode(cursor.getInt(0));
            itemProduct.setTitle(cursor.getString(1));
            itemProduct.setImage(cursor.getInt(2));
            Category category = new Category();
            category.setId(cursor.getInt(3));
            category.setName(cursor.getString(4));
            itemProduct.setCategory(category);
            itemProducts.add(itemProduct);
        }
        try{
            cursor.close();
            db.close();
        }catch (Exception e){

        }

        db = null;
        cursor = null;

        return itemProducts;
    }

    public ItemProduct getItemProductById(int idItemProduct, DataBaseHandler dh) {
        ItemProduct itemProduct = new ItemProduct();
        String selectQuery = "SELECT   P."  + DBConstants.KEY_PRODUCT_ID +", " + "P." + DBConstants.KEY_PRODUCT_TITLE +", "
                                            + "P." + DBConstants.KEY_PRODUCT_IMAGE +", "
                                            + "C." + DBConstants.KEY_CATEGORY_ID + "," + "C." + DBConstants.KEY_CATEGORY_NAME
                                            + " FROM " + DBConstants.TABLE_PRODUCT + " P, " + DBConstants.TABLE_CATEGORY + " C "
                                            + "WHERE P." + DBConstants.KEY_PRODUCT_ID + "= " + idItemProduct
                                            + " AND P." + DBConstants.KEY_PRODUCT_CATEGORY + " = C." + DBConstants.KEY_CATEGORY_ID;
        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            itemProduct.setCode(cursor.getInt(0));
            itemProduct.setTitle(cursor.getString(1));
            itemProduct.setImage(cursor.getInt(2));
            Category category = new Category();
            category.setId(cursor.getInt(3));
            category.setName(cursor.getString(4));
            itemProduct.setCategory(category);
        }
        try {cursor.close();db.close();
        } catch (Exception e) {}
        db = null;
        cursor = null;

        return itemProduct;
    }

    public int updateItemProduct(ItemProduct itemProduct, DataBaseHandler dh) {
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBConstants.KEY_PRODUCT_TITLE, itemProduct.getTitle());
        values.put(DBConstants.KEY_PRODUCT_IMAGE, itemProduct.getImage());
        values.put(DBConstants.KEY_PRODUCT_CATEGORY, itemProduct.getCategory().getId());
        // Updating row
        int count = db.update(DBConstants.TABLE_STORE, values,
                DBConstants.KEY_PRODUCT_ID + " = ?",
                new String[] { String.valueOf(itemProduct.getCode()) });
        try { db.close();} catch (Exception e) {}
        db = null;
        return count;
    }





}
