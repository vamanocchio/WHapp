package vam.whapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by victoria on 3/27/18.
 */

public class WM extends Activity{

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
        setContentView(R.layout.wm);

        listView = (ListView) findViewById(R.id.InvList);
        arrayList = db.getWH();
        adapter = new ArrayAdapter<String>(this, R.layout.inv_list, R.id.itemTxt, arrayList);


        listView.setAdapter(adapter);


        Button btnreturn = (Button)findViewById(R.id.bWMReturn);
        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WM.this, home.class);
                startActivity(i);
            }
        });
    }
}
