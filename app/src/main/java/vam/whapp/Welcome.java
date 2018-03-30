package vam.whapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by victoria on 3/29/18.
 */

public class Welcome extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    void onWelcomeClick(View v){

        if(v.getId() == R.id.bLogin){
            //
            EditText email = (EditText)findViewById(R.id.TFloginemail);
            EditText pword = (EditText)findViewById(R.id.TFloginpword);
            String stremail = email.getText().toString();
            String strpword = pword.getText().toString();

            //check if correct

     //       Intent i = new Intent(Welcome.this, )
        }

        if(v.getId() == R.id.bSignup){
            //intent
            //start Activity
        }
    }
}
