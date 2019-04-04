package com.iteso.sesion9.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iteso.sesion9.beans.Category;
import com.iteso.sesion9.tools.DBConstants;

import java.util.ArrayList;

public class CategoryControl {

    public long addCategory(Category category, DataBaseHandler dh){
        long rowID = 0;
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBConstants.KEY_CATEGORY_ID, category.getId());
        contentValues.put(DBConstants.KEY_CATEGORY_NAME, category.getName());

        rowID = db.insert(DBConstants.TABLE_CATEGORY, null, contentValues);

        try{
            db.close();
        }catch (Exception e){

        }
        db = null;
        contentValues = null;

        return rowID;
    }

    public void deleteCategory(int id, DataBaseHandler dh){
        SQLiteDatabase db = dh.getWritableDatabase();
        db.delete(DBConstants.TABLE_CATEGORY,
                  DBConstants.KEY_CATEGORY_ID +" = ?",
                    new String[]{ String.valueOf(id)});
        try{
            db.close();
        }catch (Exception e){

        }
        db = null;
    }

    public ArrayList<Category> getCategories(DataBaseHandler dh){
        SQLiteDatabase db = dh.getReadableDatabase();
        ArrayList<Category> categories = new ArrayList<>();

        String select = "SELECT " + DBConstants.KEY_CATEGORY_ID +", " + DBConstants.KEY_CATEGORY_NAME + " FROM " + DBConstants.TABLE_CATEGORY;
        Cursor cursor = db.rawQuery(select, null);
        while(cursor.moveToNext()){
            Category category = new Category();
            category.setId(cursor.getInt(0));
            category.setName(cursor.getString(1));
            categories.add(category);
        }
        try{
            cursor.close();
            db.close();
        }catch (Exception e){

        }

        return categories;
    }

    public Category getCategoryById(int idCategory, DataBaseHandler dh) {
        Category category = new Category();
        String selectQuery = "SELECT S."  + DBConstants.KEY_CATEGORY_ID + ", S." + DBConstants.KEY_CATEGORY_NAME
                                        + " FROM " + DBConstants.TABLE_STORE + " S, "
                                        + "WHERE S." + DBConstants.KEY_CATEGORY_ID + "= " + idCategory;

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            category.setId(cursor.getInt(0));
            category.setName(cursor.getString(1));
        }
        try {cursor.close();db.close();
        } catch (Exception e) {
        }

        db = null;
        cursor = null;

        return category;
    }

}
