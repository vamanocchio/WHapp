package vam.whapp;

import android.app.AlarmManager;

import android.app.PendingIntent;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import java.util.Calendar;

import java.util.Calendar;

public class home extends AppCompatActivity {

    private BottomNavigationView navBot;

    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        //ALARM MANAGER
//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.HOUR_OF_DAY, 12);
//        cal.set(Calendar.MINUTE, 30);
//        Intent intent1 = new Intent(home.this, NotifcationReceiver.class);
//        PendingIntent pen = PendingIntent.getBroadcast(home.this, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
//        AlarmManager am = (AlarmManager) home.this.getSystemService(home.this.ALARM_SERVICE);
//        am.setInexactRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pen);

        //NAV BAR

        setup();



        //NAV MENU
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
                        i = new Intent(home.this, WH.class);
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

    private void setup(){

        alarmMgr = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getApplicationContext(), NotificationReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.HOUR_OF_DAY, 12); //default alarm daily at noon

        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 1000 * 60 * 20, alarmIntent);

    }

}
