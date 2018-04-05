package vam.whapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class home extends AppCompatActivity {

    private BottomNavigationView navBot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navBot = (BottomNavigationView)findViewById(R.id.NavBot);
        navBot.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent i;
                switch(item.getItemId()){
                    case R.id.action_add:
                        i = new Intent(home.this, AddItem.class);
                        //putExtra
                        startActivity(i);
                        return true;
                    case R.id.action_inv:
                        i = new Intent(home.this, Inventory.class);
                        startActivity(i);
                        return true;
                    case R.id.action_shop:
                        i = new Intent(home.this, Shopping.class);
                        startActivity(i);
                        return true;
                    case R.id.action_wh:
                        i = new Intent(home.this, WM.class);
                        startActivity(i);
                        return true;
                    case R.id.action_set:
                        i = new Intent(home.this, Settings.class);
                        startActivity(i);
                        return true;

                }
                return false;
            }
        });

    }

}
