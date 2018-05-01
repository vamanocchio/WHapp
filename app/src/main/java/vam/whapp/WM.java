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
    TextView tv_wh_name, tv_wh_id;
    ListView mem_list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        String wh_id = extras.getString("WH_ID");
        String wh_title = extras.getString("WH_title");

        tv_wh_name = (TextView)findViewById(R.id.TV_WH);
        tv_wh_id = (TextView)findViewById(R.id.TV_ID);

        tv_wh_name.setText(wh_title);
        tv_wh_id.setText(wh_id);
        //mem_list = (ListView)findViewById(R.id.LV_WHList);

        //Cursor c = db.rawQuery("SELECT title FROM " + TABLE_WH + " WHERE id=id_str", null);
//        String query = "SELECT title FROM warehouses WHERE id=id_str";
//        Cursor c = db.rawQuery(query, null);
        //SELECT title FROM WH WHERE Id=id_str;
        //w3schools

    }


}
