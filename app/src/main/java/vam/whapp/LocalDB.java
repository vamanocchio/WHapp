package vam.whapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by resnet on 3/28/18.
 */

public class LocalDB extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "localuser.db";

    private static String TABLE_USER = "User";
    private static String COLUMN_USER_ID = "user_id";
    private static String COLUMN_USER_NAME = "user_name";
    private static String COLUMN_EMAIL = "email";
    private static String COLUMN_PHONE = "phone";
    private static String COLUMN_PWORD = "password";

    private static String TABLE_ITEM = "Item";
    private static String COLUMN_ITEM_ID = "item_id";
    private static String COLUMN_ITEM_NAME = "item_name";
    private static String COLUMN_PRICE = "price";
    private static String COLUMN_EXP = "exp date";
    private static String COLUMN_QTY = "quantity";
    private static String COLUMN_LOC = "location";
    private static String COLUMN_NOTES = "notes";

    private static String TABLE_INV = "Inventory";
    private static String COLUMN_INV_ID = "inv_id";
    private static String COLUMN_TITLE = "title";
    private static String COLUMN_FK_ITEM_ID = "fk_item_id";

    private static String TABLE_WH = "Warehouse";
    private static String COLUMN_WH_ID = "warehouse_id";
    private static String COLUMN_FK_INV_ID = "fk_inv_id";
    private static String COLUMN_FK_TITLE = "fk_title";
    private static String COLUMN_FK_USER_ID = "fk_user_id";



    SQLiteDatabase db;

    private static final String CREATE_TABLE_USER = "create table User (user_id text primary key autoincrement, user_name text not null, email text not null, phone text, password text not null)";
    private static final String CREATE_TABLE_ITEM = "create table Item (item_id text primary key autoincrement, item_name text not null, price text not null, exp date text, quantity text, location text, notes text)";
    private static final String CREATE_TABLE_INV = "create table Inventory (inv_id text primary key autoincrement, title text not null, foreign key(fk_item_id) references Item(item_id))";
    private static final String CREATE_TABLE_WH = "create table Warehouse (warehouse_id text primary key autoincrement, foreign key(fk_inv_id) references Inventory(inv_id), foreign key(fk_title) references Inventory(title), foreign key(fk_user_id) references User(user_id))";



//    private static final String CREATE_TABLE_ITEM = "create table inventory (item text primary key not null, exp text not null, price text not null, location text not null, notes text)" ;

//    private static final String CREATE_TABLE_LU = "create table lookup (item text primary key not null, exp text not null, price text not null, location text not null, notes text)";

 //   private static final String CREATE_TABLE_WH = "create table warehouses (id text primary key not null, owner text not null, members text)";

//    private static final String CREATE_TABLE_USER = "create table user (email text primary key not null, password text not null, phone text not null)";



    public LocalDB(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    void insertUser(User u){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_ID, u.getID());
        values.put(COLUMN_USER_NAME, u.getName());
        values.put(COLUMN_EMAIL, u.getEmail());
        values.put(COLUMN_PHONE, u.getPhone());
        values.put(COLUMN_PWORD, u.getPword());

        db.insert(TABLE_USER, null, values);
        db.close();
    }


    void insertUser(User u){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, u.getEmail());
        values.put(COLUMN_PWORD, u.getPword());
        values.put(COLUMN_PHONE, u.getPhone());
//        values.put(COLUMN_ID, u.getId());

        db.insert(TABLE_USER, null, values);
        db.close();
    }


    void insertItem2(Item i){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ITEM_ID, i.getID());
        values.put(COLUMN_ITEM_NAME, i.getName());
        values.put(COLUMN_PRICE, i.getPrice());
        values.put(COLUMN_EXP, i.getExp());
        values.put(COLUMN_QTY, i.getQty());
        values.put(COLUMN_LOC, i.getLoc());
        values.put(COLUMN_NOTES, i.getNotes());

        db.insert(TABLE_ITEM, null, values);
        db.close();
    }

//    void insertItem(Item i){
//
//        Log.d("InDB", "In DB, congrats");
//        String output = (i.getName() + " " + i.getExp() + " " + i.getPrice() + " " + i.getLoc() + " " + i.getNotes());
//        Log.d("DBTag", output);
//
//        db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_ITEM, i.getName());
//        values.put(COLUMN_EXP, i.getExp());
//        values.put(COLUMN_PRICE, i.getPrice());
//        values.put(COLUMN_LOC, i.getLoc());
//        values.put(COLUMN_NOTES, i.getNotes());
//
//        db.insert(TABLE_INV, null, values);
//        db.close();
//    }


    void insertInv(Inventory i){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_INV_ID, i.getID());
        values.put(COLUMN_TITLE, i.getTitle());
        //add items in Inventory class

        db.insert(TABLE_INV, null values);
    }


    void insertWH(Warehouse w){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_WH_ID, i.getID());
        //add
    }




    ArrayList<String> getInv(){
        ArrayList<String> list = new ArrayList<String>();

        db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select item from " + TABLE_INV, null);

        if(c!=null){
            if(c.moveToFirst()){
                do{
                    String item = c.getString(c.getColumnIndex("item"));
                    list.add(item);

                }while(c.moveToNext());
            }
        }
        db.close();
        return list;
    }

    boolean isUser(String email, String pword){

        db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select email, password from " + TABLE_USER, null);

        if(c!=null){
            if(c.moveToFirst()){
                do{
                    if(c.getString(0).equals(email)){
                        if(c.getString(1).equals(pword)) {
                            return true;
                        }else{ return false; }
                    }
                }while(c.moveToNext());
            }
        }
        return false;
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_ITEM);
        db.execSQL(CREATE_TABLE_LU);
        db.execSQL(CREATE_TABLE_WH);
        db.execSQL(CREATE_TABLE_USER);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String query = "DROP TABLE IF EXISTS " + TABLE_INV + ", " + TABLE_LU + ", " + TABLE_WH + ", " + TABLE_USER;
        db.execSQL(query);
        this.onCreate(db);
    }
}
