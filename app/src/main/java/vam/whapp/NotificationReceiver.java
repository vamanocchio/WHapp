package vam.whapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import java.util.ArrayList;

/**
 * Created by resnet on 4/23/18.
 */

public class NotificationReceiver extends BroadcastReceiver{

    public ArrayList<Item> exp_list = new ArrayList<Item>();

    @Override
    public void onReceive(Context context, Intent intent){

//        long when = System.currentTimeMillis();
//        NotificationManager notif_man = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        Intent notif_intent = new Intent(context, Notification.class);
//        notif_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        PendingIntent pen = PendingIntent.getActivity(context, 0, notif_intent, PendingIntent.FLAG_UPDATE_CURRENT);
//
//        NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(
//                context).setSmallIcon(R.drawable.ic_inv)
//                .setContentTitle("Alarm Fired")
//                .setContentText("Events to be Performed")
//                .setAutoCancel(true).setWhen(when)
//                .setContentIntent(pen); //***WHERE THE NOTIFICATION TAKES YOU WHEN PRESSED
//        notif_man.notify(0, mNotifyBuilder.build());

    }
}
