package vam.whapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Victoria on 4/29/2018.
 */

public class createWH extends Activity{

    LocalDB db = new LocalDB(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_wh);
    }

    void onCreateClick(View v){

        if(v.getId() == R.id.b_OK_CREATE_WH){

            EditText wh_title = (EditText)findViewById(R.id.TF_create_WH);

            String title_str = wh_title.getText().toString();
            long curr_user = ((GlobalVar) this.getApplication()).getUser();
            String wh_id = db.insertWH(title_str, curr_user);

            ((GlobalVar) this.getApplication()).setWH(wh_id);

            Intent i = new Intent(createWH.this, home.class);
            startActivity(i);
            //TODO ALL DISH SHIII ---------------------------------------------------------!!
            //long curr_user = ((GlobalVar) this.getApplication()).getUser();
            //long wh_id = insertWH(title_str, curr_user);

            //Inventory will now insert records by grabbing the curr_wh_id and passing a tuple (or item)
            //of shit to be entered into the database
            //Inventory will be populated by querying TABLE_INV for foreign key equalling curr_wh_id
            //YAAAAAAAAAAAY ;-;
        }


    }

}
