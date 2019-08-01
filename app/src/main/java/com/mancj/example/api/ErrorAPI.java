package com.mancj.example.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ErrorAPI {

    public static boolean checkConnection(Context context) {
        boolean connection = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if ((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) {
                connection = true;
            } else {
                connection = false;
            }
        } else {
            connection = false;
        }

        return connection;
    }

}
