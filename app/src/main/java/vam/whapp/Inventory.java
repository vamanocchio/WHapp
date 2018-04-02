package vam.whapp;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victoria on 3/27/18.
 */

public class Inventory extends Activity{

    private EditText editTxt;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private Dialog MyDialog;
    Button hello,close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);


        ListView listView = (ListView) findViewById(R.id.InvList);
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, R.layout.inv_list, R.id.itemTxt, arrayList);

        listView.setAdapter(adapter);
        editTxt = (EditText)findViewById(R.id.itemInput);
        Button btnadd = (Button)findViewById(R.id.bAddInv);
        btnadd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                String newItem = editTxt.getText().toString();
  //              arrayList.add(newItem);
    //            adapter.notifyDataSetChanged();
                CAD();
            }
        });

    }

    public void CAD(){
        MyDialog = new Dialog(this);
        MyDialog.setContentView(R.layout.add_inv_dialog);
        MyDialog.setTitle("VAM Custom Dialog");

        hello = (Button)MyDialog.findViewById(R.id.hello);
        close = (Button)MyDialog.findViewById(R.id.close);

        hello.setEnabled(true);
        close.setEnabled(true);

        hello.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Hello World. Programmed to work and not to feel.", Toast.LENGTH_LONG).show();
            }
        });
        close.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                MyDialog.cancel();
            }
        });

        MyDialog.show();
    }

//    void onOkClick(View v){
//
  //      editTxt = (EditText) findViewById(R.id.editText);
    //    arrayList.add(editTxt.getText().toString());
      //  adapter.notifyDataSetChanged();

        //add to database
//    }
}
