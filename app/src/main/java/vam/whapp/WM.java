package vam.whapp;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

class ViewWH extends Activity{

    LocalDB db = new LocalDB(this);
    TextView wh_name, wh_id;
    ListView mem_list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        String id_str = i.getExtras().toString();

        wh_name = (TextView)findViewById(R.id.TV_WH);
        wh_id = (TextView)findViewById(R.id.TV_ID);
        mem_list = (ListView)findViewById(R.id.LV_WHList);

        //Cursor c = db.rawQuery("SELECT title FROM " + TABLE_WH + " WHERE id=id_str", null);
        String query = "SELECT title FROM warehouses WHERE id=id_str";
        Cursor c = db.rawQuery(query, null);
        //SELECT title FROM WH WHERE Id=id_str;
        //w3schools

    }


}
