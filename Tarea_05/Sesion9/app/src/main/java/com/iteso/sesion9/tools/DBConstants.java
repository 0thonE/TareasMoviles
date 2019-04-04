package com.iteso.sesion9.tools;

public class DBConstants {

    // Tables' names
    public static final String TABLE_CITY = "City";
    public static final String TABLE_CATEGORY = "Category";
    public static final String TABLE_STORE = "Store";
    public static final String TABLE_PRODUCT = "Product";
    public static final String TABLE_STORE_PRODUCT = "StoreProduct";

    // Columns City table
    public static final String KEY_CITY_ID = "idCity";
    public static final String KEY_CITY_NAME = "name";

    // Columns Category table
    public static final String KEY_CATEGORY_ID = "idCategory";
    public static final String KEY_CATEGORY_NAME = "name";

    // Columns Store table
    public static final String KEY_STORE_ID = "idStore";
    public static final String KEY_STORE_NAME = "name";
    public static final String KEY_STORE_PHONE = "phone";
    public static final String KEY_STORE_CITY = "idCity";
    public static final String KEY_STORE_THUMBNAIL = "thumbnail";
    public static final String KEY_STORE_LAT = "latitude";
    public static final String KEY_STORE_LNG = "longitude";

    // Columns Product table
    public static final String KEY_PRODUCT_ID = "idProduct";
    public static final String KEY_PRODUCT_TITLE = "name";
    public static final String KEY_PRODUCT_IMAGE = "image";
    public static final String KEY_PRODUCT_CATEGORY = "idCategory";

    // Columns StoreProduct table
    public static final String KEY_STORE_PRODUCT_ID = "idStoreProduct";
    public static final String KEY_STORE_PRODUCT_PRODUCT = "idProduct";
    public static final String KEY_STORE_PRODUCT_STORE = "idStore";

    // Table creation statements
    public static final String CREATE_CITY_TABLE = "CREATE TABLE " + DBConstants.TABLE_CITY + "("
            + DBConstants. KEY_CITY_ID + " INTEGER PRIMARY KEY,"
            + DBConstants. KEY_CITY_NAME + " TEXT" +
            ")";

    public static final String CREATE_CATEGORY_TABLE = "CREATE TABLE " + DBConstants.TABLE_CATEGORY + "("
            + DBConstants.KEY_CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + DBConstants.KEY_CATEGORY_NAME + " TEXT" +
            ")";

    public static final  String CREATE_STORE_TABLE = "CREATE TABLE " + DBConstants.TABLE_STORE + "("
            + DBConstants.KEY_STORE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + DBConstants. KEY_STORE_NAME + " TEXT,"
            + DBConstants. KEY_STORE_PHONE + " TEXT,"
            + DBConstants.KEY_STORE_CITY + " INTEGER,"
            + DBConstants.KEY_STORE_THUMBNAIL + " INTEGER,"
            + DBConstants.KEY_STORE_LAT + " DOUBLE,"
            + DBConstants.KEY_STORE_LNG + " DOUBLE" +
            ")";

    public static final String CREATE_PRODUCT_TABLE = "CREATE TABLE " + DBConstants.TABLE_PRODUCT + "("
            + DBConstants.KEY_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + DBConstants.KEY_PRODUCT_TITLE + " TEXT,"
            + DBConstants.KEY_PRODUCT_IMAGE + " INTEGER,"
            + DBConstants.KEY_PRODUCT_CATEGORY + " INTEGER" +
            ")";

    public static final String CREATE_STORE_PRODUCT_TABLE = "CREATE TABLE " + DBConstants.TABLE_STORE_PRODUCT + "("
            + DBConstants.KEY_STORE_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + DBConstants.KEY_STORE_PRODUCT_PRODUCT + " INTEGER,"
            + DBConstants.KEY_STORE_PRODUCT_STORE + " INTEGER" +
            ")";


}
