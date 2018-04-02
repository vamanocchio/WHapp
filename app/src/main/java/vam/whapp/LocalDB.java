package vam.whapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by resnet on 3/28/18.
 */

public class LocalDB extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "localuser.db";

    private static final String TABLE_INV = "inventory";
    private static final String COLUMN_ITEM = "item";
    private static final String COLUMN_EXP = "exp";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_LOC = "location";
    private static final String COLUMN_NOTES = "notes";

    private static final String TABLE_LU = "lookup";
    private static final String COLUMN_LUITEM = "lu_item";
    private static final String COLUMN_LUEXP = "lu_exp";
    private static final String COLUMN_LUPRICE = "lu_price";
    private static final String COLUMN_LULOC = "lu_location";
    private static final String COLUMN_LUNOTES = "lu_notes";

    private static final String TABLE_WH = "warehouses";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_OWNER = "owner";
    private static final String COLUMN_MEMBERS = "members";

    private static final String TABLE_USER = "user";
    private static final String COLUMN_UNAME = "username";  //Replaced by email?
    private static final String COLUMN_PWORD = "password";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PHONE = "phone";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table inventory (item text not null, exp text not null, location text not null)," +
            " create table lookup, create table warehouses (id text not null, owner text not null)," +
            " create table user (username text not null, password text not null, email text not null, phone text not null)";

    public LocalDB(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    void insertUser(User u){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, u.getEmail());
        values.put(COLUMN_PWORD, u.getPword());
        values.put(COLUMN_PHONE, u.getPhone());
        values.put(COLUMN_ID, u.getId());

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    void insertItem(Item i){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ITEM, i.getName());
        values.put(COLUMN_EXP, i.getExp());
        values.put(COLUMN_PRICE, i.getPrice());
        values.put(COLUMN_LOC, i.getLoc());
        values.put(COLUMN_NOTES, i.getNotes());

        db.insert(TABLE_INV, null, values);
        db.close();
    }






    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String query = "DROP TABLE IF EXISTS " + TABLE_INV + ", " + TABLE_LU + ", " + TABLE_WH + ", " + TABLE_USER;
        db.execSQL(query);
        this.onCreate(db);
    }
}
