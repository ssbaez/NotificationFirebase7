package com.ss_baez.notificationfirebase7;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lanzarNotificacion(View v){
        Intent intent = new Intent(this, MainActivity.class);

        /*Primero pide el contexto (this) despues un código de solic y se puede poner a criterio propio,
        * y despues solicita el intent y después una bandera*/
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        //Para el sonido de la notificacion
        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        /*Ahora se trabajara en la notificación, a traves del objeto NotificationCompat. La clase NOTIFICATION
          * MANAGER sera la encargada de estar mandando la notificacion que se defina */
        android.support.v4.app.NotificationCompat.Builder notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.phone_48)
                .setContentTitle("Notificacion")
                .setContentText("Hola Mundo")
                .setSound(sonido)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                ;
        //Hasta aquí queda configurada la notificacion

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification.build());

    }
}
