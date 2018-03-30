package vam.whapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListPopupWindow;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victoria on 3/27/18.
 */

public class Inventory extends Activity{

    private EditText editTxt;
    private Button btn;
    private ListView list;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);

        editTxt = (EditText) findViewById(R.id.editText);
        btn = (Button) findViewById(R.id.button);
        list = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.inventory, arrayList);

        list.setAdapter(adapter);

    }

    void onOkClick(View v){

        arrayList.add(editTxt.getText().toString());
        adapter.notifyDataSetChanged();

        //add to database
    }
}
