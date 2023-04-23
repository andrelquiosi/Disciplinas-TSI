package com.example.processolongo;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class GeradorNumeros extends IntentService {


    public GeradorNumeros() {
        super("GeradorNumeros");
    }


    @Override
    protected void onHandleIntent(Intent it) {
        if (it != null) {
            int quantidade = it.getIntExtra("quantidade", 10);
            ArrayList<Integer> numeros = new ArrayList<Integer>();
            Random r = new Random(System.currentTimeMillis());
            for (int x = 0; x < quantidade; x++) {
                int novo = r.nextInt(10000);
                numeros.add(novo);
                Log.d("Numero gerado", "" + novo);
                try {
                    Thread.sleep(1000);
                } catch (Throwable t) {

                }
            }
            Intent intent = new Intent(getApplicationContext(), ListaNumeros.class);
            intent.putIntegerArrayListExtra("lista", numeros);
            PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

            // Configurando a notificação
            NotificationCompat.Builder bld = new NotificationCompat.Builder(getApplicationContext(), "TESTE");
            bld.setContentTitle("Terminou");
            bld.setContentText("A geração dos números terminou.\nClique para ver o resultado");
            bld.setSmallIcon(R.mipmap.ic_launcher_round);
            bld.setContentIntent(pendingIntent);
            bld.setAutoCancel(true);

            // Recuperando o NotificationManager e gerando a notificação
            NotificationManager nmc = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            nmc.notify(12313, bld.build());
        }
    }

}