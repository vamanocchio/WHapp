package vam.whapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by victoria on 3/27/18.
 */

public class WH extends Activity {

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    //    private Dialog MyDialog;
//    Button hello,close;
    ListView listView;
    String item;
    LocalDB db = new LocalDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wh);

        listView = (ListView) findViewById(R.id.InvList);
        arrayList = db.getWarehouses();
        adapter = new ArrayAdapter<String>(this, R.layout.inv_list, R.id.itemTxt, arrayList);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String title = (String)listView.getItemAtPosition(position);
                String id_str = db.getWH_ID(title);
                Intent i = new Intent (WH.this, ViewWH.class);
                i.putExtra("WH_ID", id_str);
                startActivity(i);
            }
        });


        Button btnreturn = (Button)findViewById(R.id.bWHReturn);
        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WH.this, home.class);
                startActivity(i);
            }
        });
    }
}
