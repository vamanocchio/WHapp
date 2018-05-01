package vam.whapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.*;
//import android.util.Pair;

import org.javatuples.*;
import org.javatuples.Pair;
//import org.javatuples.Sextet;
//import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by resnet on 3/28/18.
 */

public class LocalDB extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "localuser.db";

    private static String TABLE_USER = "User";
    private static String COLUMN_USER_ID = "user_id";
    private static String COLUMN_USER_NAME = "user_name";
    private static String COLUMN_PWORD = "password";
    private static String COLUMN_EMAIL = "email";
    private static String COLUMN_PHONE = "phone";


    private static String TABLE_ITEM = "Item";
    private static String COLUMN_ITEM_ID = "item_id"; //pk
    private static String COLUMN_ITEM_NAME = "item_name";
    private static String COLUMN_PRICE = "price";
    private static String COLUMN_EXP = "exp_date";
    private static String COLUMN_QTY = "quantity";
    private static String COLUMN_LOC = "location";
    private static String COLUMN_NOTES = "notes";

    private static String TABLE_INV = "Inventory";
    private static String COLUMN_INV_NUM = "inv_num"; //pk
    private static String COLUMN_FK_WH_ID = "fk_wh_id"; //fk ref Warehouse(wh_id)
  //  private static String COLUMN_FK_TITLE = "fk_title"; //fk ref Warehouse(title)
    private static String COLUMN_FK_ITEM_ID = "fk_item_id"; //fk ref Item(item_id)

    private static String TABLE_WH = "Warehouse";
    private static String COLUMN_WH_NUM = "warehouse_num"; //pk
    private static String COLUMN_WH_ID = "wh_id"; //gen and verify is unique
    private static String COLUMN_TITLE = "wh_title";
    private static String COLUMN_FK_USER_ID = "fk_user_id";



    SQLiteDatabase db;

    private static final String CREATE_TABLE_USER = "create table User (user_id integer primary key autoincrement, user_name text not null, password text not null , email text not null, phone text)";

    private static final String CREATE_TABLE_ITEM = "create table Item (item_id integer primary key autoincrement, item_name text not null, price real not null, exp_date integer, quantity integer, location text, notes text)";

    private static final String CREATE_TABLE_WH = "create table Warehouse (warehouse_num integer primary key autoincrement, wh_id text unique not null, wh_title text not null, fk_user_id integer, foreign key (fk_user_id) references User(user_id))";

   // private static final String CREATE_TABLE_INV = "create table Inventory (inv_num integer primary key autoincrement, fk_wh_id text not null, foreign key (fk_wh_id) references Warehouse(wh_id), fk_wh_title text not null, foreign key (fk_wh_title) references Warehouse(wh_title), fk_item_id integer not null, foreign key (fk_item_id) references Item(item_id))";

    private static final String CREATE_TABLE_INV = "create table Inventory (inv_num integer primary key autoincrement, fk_wh_id text not null, fk_wh_title text not null, fk_item_id integer not null, foreign key (fk_item_id) references Item(item_id), foreign key (fk_wh_id) references Warehouse(wh_id), foreign key (fk_wh_title) references Warehouse(wh_title))";





//    private static final String CREATE_TABLE_ITEM = "create table inventory (item text primary key not null, exp text not null, price text not null, location text not null, notes text)" ;

//    private static final String CREATE_TABLE_LU = "create table lookup (item text primary key not null, exp text not null, price text not null, location text not null, notes text)";

 //   private static final String CREATE_TABLE_WH = "create table warehouses (id text primary key not null, owner text not null, members text)";

//    private static final String CREATE_TABLE_USER = "create table user (email text primary key not null, password text not null, phone text not null)";



    public LocalDB(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    long insertUser(Quartet<String, String, String, String> user){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_USER_NAME, user.getValue0());
        values.put(COLUMN_PWORD, user.getValue1());
        values.put(COLUMN_EMAIL, user.getValue2());
        values.put(COLUMN_PHONE, user.getValue3());

        long id = db.insert(TABLE_USER, null, values);
        db.close();
        return id;

    }

    long insertItem(Item i, String wh_id){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_ITEM_NAME, i.getName());
        values.put(COLUMN_PRICE, i.getPrice());
        values.put(COLUMN_EXP, i.getExp());
        values.put(COLUMN_QTY, i.getQty());
        values.put(COLUMN_LOC, i.getLoc());
        values.put(COLUMN_NOTES, i.getNotes());

        long id = db.insert(TABLE_ITEM, null, values);
        insertInv(id, wh_id);
        db.close();
        return id;
    }

    String insertWH(String title, long user_id){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String id = genID();
        values.put(COLUMN_WH_ID, id);
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_FK_USER_ID, user_id);

        db.insert(TABLE_WH, null, values);
        db.close();
        return id;

    }

    long insertInv(long item_id, String wh_id){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_FK_WH_ID, wh_id);
        values.put(COLUMN_FK_ITEM_ID, item_id);

        long id = db.insert(TABLE_INV, null, values);
        db.close();
        return id;
    }


//    long insertUser(User u){
//
//        db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
////        values.put(COLUMN_USER_ID, u.getID());
//        values.put(COLUMN_USER_NAME, u.getName());
//        values.put(COLUMN_EMAIL, u.getEmail());
//        values.put(COLUMN_PHONE, u.getPhone());
//        values.put(COLUMN_PWORD, u.getPword());
//
//        long id = db.insert(TABLE_USER, null, values);
//        db.close();
//        return id;
//    }


//    long insertUser(User u){

 //       db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_EMAIL, u.getEmail());
//        values.put(COLUMN_PWORD, u.getPword());
//        values.put(COLUMN_PHONE, u.getPhone());
//        values.put(COLUMN_ID, u.getId());

//        long id = db.insert(TABLE_USER, null, values);
//        db.close();
//        return id;
//    }


//    void insertItem2(Item i){
//
//        db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_ITEM_ID, i.getID());
//        values.put(COLUMN_ITEM_NAME, i.getName());
//        values.put(COLUMN_PRICE, i.getPrice());
//        values.put(COLUMN_EXP, i.getExp());
//        values.put(COLUMN_QTY, i.getQty());
//        values.put(COLUMN_LOC, i.getLoc());
//        values.put(COLUMN_NOTES, i.getNotes());
//
//        db.insert(TABLE_ITEM, null, values);
//        db.close();
//    }

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


//    void insertInv(Inventory i){
//
//        db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_INV_ID, i.getID());
//        values.put(COLUMN_TITLE, i.getTitle());
//        //add items in Inventory class
//
//        db.insert(TABLE_INV, null, values);
//    }
//
//
//    long insertWH(String title, long user_id){
//
//        db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        //values.put(COLUMN_WH_ID, i.getID());
//        values.put(COLUMN_TITLE, title);
//        //add
//    }

    Quintet<Long, String, String , String, String> getUser(long id){

        Quintet<Long, String, String, String, String> user = new Quintet<>(null, null, null, null, null);

        db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_USER + " where user_id = " + id, null);

        if(c!=null){
            if(c.moveToFirst()){
                do{
                    String name = c.getString(c.getColumnIndex("user_name"));
                    String pword = c.getString(c.getColumnIndex("pword"));
                    String email = c.getString(c.getColumnIndex("email"));
                    String phone = c.getString(c.getColumnIndex("phone"));

                    user = new Quintet<>(id, name, pword, email, phone);
                }while(c.moveToNext());
            }
        }
        db.close();
        return user;
    }

    ArrayList<String> getInv(String wh_id){

        ArrayList<String> list = new ArrayList<>();
        db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select Inventory.fk_item_id, Item.item_name from Inventory, Item where Inventory.fk_item_id = Item.item_id and Inventory.fk_wh_id = \"" + wh_id + "\"", null);

        if(c!=null){
            if(c.moveToFirst()){
                do{
                    //long item_id = c.getLong(c.getColumnIndex("fk_item_id"));
                    String item_name = c.getString(c.getColumnIndex("item_name"));
                    list.add(item_name);
                }while(c.moveToNext());
            }
        }
        return list;
    }
    // SELECT
    //WHERE inv.fk_item_id = item.item_id AND inv.fk_wh_id = "id"

    Septet<Long, String, Float, Integer, Integer, String, String> getItem(long id){

        Septet<Long, String, Float, Integer , Integer, String, String> item = new Septet<>(null, null, null, null, null, null, null);
        db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from Item where item_id = id", null);

        if(c!=null){
            if(c.moveToFirst()){
                do{
                    String name = c.getString(c.getColumnIndex("item_name"));
                    Float price = c.getFloat(c.getColumnIndex("price"));
                    Integer exp = c.getInt(c.getColumnIndex("exp_date"));
                    Integer qty = c.getInt(c.getColumnIndex("quantity"));
                    String loc = c.getString(c.getColumnIndex("location"));
                    String notes = c.getString(c.getColumnIndex("notes"));

                    item = new Septet<>(id, name, price, exp, qty, loc, notes);
                }while(c.moveToNext());
            }
        }
        return item;
        // select * from Item where item_id = id
    }

    String getWH_ID(String title, long curr_user){
        String id = null;
        db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select wh_id from Warehouses where wh_title = title and fk_user_id = curr_user", null);

        if(c!=null){
            if(c.moveToFirst()){
                do{
                    id = c.getString(c.getColumnIndex("wh_id"));
                }while(c.moveToNext());
            }
        }
        return id;
    }

    ArrayList<String> getWarehouses(){
        ArrayList<String> list = new ArrayList<>();
        db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select wh_title from Warehouses", null);

        if(c!=null){
            if(c.moveToFirst()){
                do{
                    String wh = c.getString(c.getColumnIndex("wh_title"));
                    list.add(wh);
                }while(c.moveToNext());
            }
        }
        db.close();
        return list;
    }


//    ArrayList<String> getInv(){
//        ArrayList<String> list = new ArrayList<String>();
//
//        db = this.getWritableDatabase();
//        Cursor c = db.rawQuery("select item from " + TABLE_INV, null);
//
//        if(c!=null){
//            if(c.moveToFirst()){
//                do{
//                    String item = c.getString(c.getColumnIndex("item"));
//                    list.add(item);
//
//                }while(c.moveToNext());
//            }
//        }
//        db.close();
//        return list;
//    }

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

    String genID(){
        return UUID.randomUUID().toString().replace("-", "");
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_ITEM);
        db.execSQL(CREATE_TABLE_WH);
        db.execSQL(CREATE_TABLE_INV);

        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String query = "DROP TABLE IF EXISTS " + TABLE_INV + ", " + TABLE_ITEM + ", " + TABLE_WH + ", " + TABLE_USER;
        db.execSQL(query);
        this.onCreate(db);
    }
}
