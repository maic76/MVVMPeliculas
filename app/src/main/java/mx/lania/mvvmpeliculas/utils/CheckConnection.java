package mx.lania.mvvmpeliculas.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import mx.lania.mvvmpeliculas.di.RemoteModule;

import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;

//TODO: Agregada nueva clase checkConnection
public class CheckConnection {

    private static CheckConnection instance = new CheckConnection();
    static Context context;
    ConnectivityManager connectivityManager;
    boolean connected = false;


    public static CheckConnection getInstance(Context ctx) {
        context = ctx.getApplicationContext();
        return instance;
    }

    public boolean isOnline() {
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            connected = networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
            //&& isServerNPortOpen();
            return connected;
        } catch (Exception e) {
            System.out.println("CheckConnectivity Exception: " + e.getMessage());
            Log.v("connectivity", e.toString());
        }
        return connected;
    }

    public static boolean isServerNPortOpen() {
        try {
            final String ip = RemoteModule.BASE_URL.split("/")[2].split(":")[0];
            final int port = Integer.parseInt(RemoteModule.BASE_URL.split("/")[2].split(":")[1]);
            final int timeout = 2000;
            Log.d("Datos server", "IP " + ip + ":" + port);
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), timeout);
            socket.close();
            return true;
        } catch (ConnectException ce) {
            ce.printStackTrace();
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
