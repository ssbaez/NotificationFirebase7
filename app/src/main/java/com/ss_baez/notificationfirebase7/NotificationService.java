package com.ss_baez.notificationfirebase7;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by SS_Baez on 12/06/2017.
 */

public class NotificationService extends FirebaseMessagingService {

    public static final String TAG = "FIREBASEE";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        android.support.v4.app.NotificationCompat.Builder notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.phone_48)
                .setContentTitle("Notificación")
                .setContentText(remoteMessage.getNotification().getBody())
                .setSound(sonido)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                ;

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification.build());
    }
}
