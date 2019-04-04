package com.iteso.sesion9.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.iteso.sesion9.ActivitySplashScreen;
import com.iteso.sesion9.beans.Category;
import com.iteso.sesion9.tools.Constant;
import com.iteso.sesion9.tools.DBConstants;


public class DataBaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Products.db";
    private static final int DATABASE_VERSION = 1;

    private static DataBaseHandler dataBaseHandler;


    private DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DataBaseHandler getInstance(Context context){
        if(dataBaseHandler == null){
            dataBaseHandler = new DataBaseHandler(context);
        }
        return dataBaseHandler;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DBConstants.CREATE_CITY_TABLE);
        db.execSQL(DBConstants.CREATE_CATEGORY_TABLE);
        db.execSQL(DBConstants.CREATE_STORE_TABLE);
        db.execSQL(DBConstants.CREATE_PRODUCT_TABLE);
        db.execSQL(DBConstants.CREATE_STORE_PRODUCT_TABLE);

        prefillTables(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
//                upgradeVersion2(db);
            case 2:
//                upgradeVersion3(db);
                break;
        }
    }

    private void prefillTables(SQLiteDatabase db){
//      Fill category table
        db.execSQL("INSERT INTO " + DBConstants.TABLE_CATEGORY + " (" + DBConstants.KEY_CATEGORY_ID + DBConstants.KEY_CATEGORY_NAME + ") VALUES (0,'TECHNOLOGY')");
        db.execSQL("INSERT INTO " + DBConstants.TABLE_CATEGORY + " (" + DBConstants.KEY_CATEGORY_NAME + ") VALUES ('HOME')");
        db.execSQL("INSERT INTO " + DBConstants.TABLE_CATEGORY + " (" + DBConstants.KEY_CATEGORY_NAME + ") VALUES ('ELECTRONICS')");
//        Fill city table
        db.execSQL("INSERT INTO " + DBConstants.TABLE_CITY + " (" + DBConstants.KEY_CITY_ID + "," + DBConstants.KEY_CITY_NAME + ") VALUES (1, 'Guadalajara')");
        db.execSQL("INSERT INTO " + DBConstants.TABLE_CITY + " (" + DBConstants.KEY_CITY_ID + "," + DBConstants.KEY_CITY_NAME + ") VALUES (2, 'San Pedro Tlaquepaque')");
        db.execSQL("INSERT INTO " + DBConstants.TABLE_CITY + " (" + DBConstants.KEY_CITY_ID + "," + DBConstants.KEY_CITY_NAME + ") VALUES (3, 'Tlajomulco')");
        db.execSQL("INSERT INTO " + DBConstants.TABLE_CITY + " (" + DBConstants.KEY_CITY_ID + "," + DBConstants.KEY_CITY_NAME + ") VALUES (4, 'Zapopan')");

        db.execSQL("INSERT INTO " + DBConstants.TABLE_STORE + " (" + DBConstants.KEY_STORE_NAME + "," + DBConstants.KEY_STORE_PHONE + "," + DBConstants.KEY_STORE_CITY
                                  + "," + DBConstants.KEY_STORE_THUMBNAIL + "," + DBConstants.KEY_STORE_LAT + "," + DBConstants.KEY_STORE_LNG + ")"
                                  + "VALUES ('BESTBUY', '01 800 237 8289', 2, 0, 20.6489713,-103.4207757)");

        db.execSQL("INSERT INTO " + DBConstants.TABLE_PRODUCT + " (" + DBConstants.KEY_PRODUCT_ID + "," + DBConstants.KEY_PRODUCT_TITLE + ","
                + DBConstants.KEY_PRODUCT_IMAGE + "," + DBConstants.KEY_PRODUCT_CATEGORY +") "
                + "VALUES (0, 'Mac', 0, 0)");

        db.execSQL("INSERT INTO " + DBConstants.TABLE_PRODUCT + " (" + DBConstants.KEY_PRODUCT_TITLE + "," + DBConstants.KEY_PRODUCT_IMAGE + "," + DBConstants.KEY_PRODUCT_CATEGORY +") "
                + "VALUES ('Allienware', 1, 0)");

        db.execSQL("INSERT INTO " + DBConstants.TABLE_PRODUCT + " (" + DBConstants.KEY_PRODUCT_TITLE + "," + DBConstants.KEY_PRODUCT_IMAGE + "," + DBConstants.KEY_PRODUCT_CATEGORY +") "
                + "VALUES ('Sheets', 2, 1)");


        db.execSQL("INSERT INTO " + DBConstants.TABLE_PRODUCT + " (" + DBConstants.KEY_PRODUCT_TITLE + "," + DBConstants.KEY_PRODUCT_IMAGE + "," + DBConstants.KEY_PRODUCT_CATEGORY +") "
                + "VALUES ('Micro', 5, 2)");

    }



//    public void upgradeVersion2(SQLiteDatabase db) {
//        db.execSQL("ALTER TABLE " + TABLE_SUBJECT + " ADD COLUMN " +
//                KEY_NEWCOLUMN + " text not null");
//    }

}
