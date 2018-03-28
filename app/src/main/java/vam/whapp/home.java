package vam.whapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    void onHomeClick(View v){

        if(v.getId() == R.id.bShopping){
            Intent i = new Intent(home.this, Shopping.class);
            startActivity(i);
        }

        if(v.getId() == R.id.bInventory){
            Intent i = new Intent(home.this, Inventory.class);
            startActivity(i);
        }

        if(v.getId() == R.id.bAdd){
            Intent i = new Intent(home.this, Inventory.class);
            //putExtra
            startActivity(i);
        }

        if(v.getId() == R.id.bWM){
            Intent i = new Intent(home.this, WM.class);
            startActivity(i);
        }

        if(v.getId() == R.id.bSettings){
            Intent i = new Intent(home.this, Settings.class);
            startActivity(i);
        }
    }
}
