package vam.whapp;


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
    private static final String COLUMN_LOC = "location";
    private static final String COLUMN_NOTES = "notes";

    private static final String TABLE_LU = "lookup";
    private static final String COLUMN_LUITEM = "lu_item";
    private static final String COLUMN_LUEXP = "lu_exp";
    private static final String COLUMN_LULOC = "lu_location";
    private static final String COLUMN_LUNOTES = "lu_notes";

    private static final String TABLE_WH = "warehouses";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_OWNER = "owner";
    private static final String COLUMN_MEMBERS = "members";

    private static final String TABLE_USER = "user";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
