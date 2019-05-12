package com.univalle.proyectofinal;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MiServicio extends Service {
    public MiServicio() {
    }



    @Override
    public void onCreate() {
        Log.d("Funcion","Oncreate()");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Funcion","OnStart()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("Funcion","OnDestroy()");
        super.onDestroy();
    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("fun","OnBlind()");
        throw new UnsupportedOperationException("Not yet implemented");
    }



}
