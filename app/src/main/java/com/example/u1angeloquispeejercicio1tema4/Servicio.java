package com.example.u1angeloquispeejercicio1tema4;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class Servicio extends AppCompatActivity {

    //private final VibrateReceiver receiver = new VibrateReceiver();
    private IntentFilter intentFilter;

    @Override
    protected void onResume() {
        super.onResume();
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(1);
    }

    @Override
    protected void onStop() {
        super.onStop();
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(2);

    }

//    @Override
//    protected void onDestroy() {
//        unregisterReceiver(receiver);
//        super.onDestroy();
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        setContentView(R.layout.activity_main);

        intentFilter = new IntentFilter("RESPONSE");
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT);
        // Inicializar Servicios desde para que apenas el aplicativo se use los servicios  se activaran
        // Verificacion de la version SDK del celular
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
         //   Inicializacion de Servicios
         //   startForegroundService(new Intent(Servicio.this, ReceptorLlamadas.class));

         //   startForegroundService(new Intent(Servicio.this, ReceptorSMS.class));
            finish();
        } else {
            startService(new Intent(Servicio.this,
         //           ReceptorLlamadas.class));
            startService(new Intent(Servicio.this,
         //           ReceptorSMS.class));
            finish();
        }
    }



}
