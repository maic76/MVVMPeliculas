package mx.lania.mvvmpeliculas.services;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import  mx.lania.mvvmpeliculas.utils.Constants;

import es.dmoral.toasty.Toasty;

public class ProgressIntentService extends IntentService {
    private static final String TAG = ProgressIntentService.class.getSimpleName();

    public ProgressIntentService() {
        super("ProgressIntentService");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (Constants.ACTION_RUN_ISERVICE.equals(action)) {
                int nPeliculas = intent.getIntExtra("totalPeliculas",1);
                manejarLaPeticion(nPeliculas);
            }
        }
    }

    // Se construye la notificación
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void notificacion(int incremento, int max) {
        String NOTIFICATION_CHANNEL_ID = " mx.lania.mvvmpeliculas";
        String channelName = "Notificacion Peliculas";

        NotificationChannel chan = new NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, NotificationManager.IMPORTANCE_NONE);
        chan.setLightColor(Color.BLUE);
        chan.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.createNotificationChannel(chan);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        Notification notification = notificationBuilder.setOngoing(true)
                .setSmallIcon(android.R.drawable.stat_sys_download_done)
                .setContentTitle("Descargando películas")
                .setContentText("Descargando "+ incremento +" de "+max)
                .setProgress(10, incremento, false)
                .build();
        // Poner en primer plano
        startForeground(2, notification);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void manejarLaPeticion(int max) {
        try {
            for (int incremento = 1; incremento <= max; incremento++) {
                notificacion(incremento, max);
                // Crear Intent para iniciar una actividad al presionar la notificación
                Intent localIntent = new Intent(Constants.ACTION_RUN_ISERVICE).putExtra(Constants.EXTRA_PROGRESS, incremento);
                LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
                Thread.sleep(500);
            }
            // Quitar de primer plano
            stopForeground(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        Toasty.info(this, "Servicio destruido...", Toast.LENGTH_SHORT).show();

        // Emisión para avisar que se terminó el servicio
        Intent localIntent = new Intent(Constants.ACTION_PROGRESS_EXIT);
        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
    }
}
