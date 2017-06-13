package com.ss_baez.notificationfirebase7;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by SS_Baez on 12/06/2017.
 */

/**
 * FirebaseInstanceIdService sirve para manejar la creación, rotación y actualización de los token de registro.
 * Esto es un requisito para enviar a dispositivos específicos o para crear grupos de dispositivos. En esta clase
 * de Java se registra el Dispositivo en Firebase y este devolvera un token
 */

public class NotificationIDService extends FirebaseInstanceIdService {

    private static final String TAG = "FIREBASE_TOKENN";

    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();
        Log.d(TAG, "Solicitando el maldito Token");
        String tokken = FirebaseInstanceId.getInstance().getToken(); //Aquí se registra el dispositivo y le devuelve un token


    }

    //Este método estará enviando el token al servidor
    private void enviarTokenRegistro1 (String tokkken){
        // TODO: Implement this method to send token to your app server.
        Log.d(TAG, tokkken);
    }
}
