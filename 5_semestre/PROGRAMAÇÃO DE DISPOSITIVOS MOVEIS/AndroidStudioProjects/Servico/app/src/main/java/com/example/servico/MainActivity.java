package com.example.servico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

import java.util.zip.CheckedOutputStream;

public class MainActivity extends AppCompatActivity {

    Gerador gerador;
    boolean conectado = false;

    private ServiceConnection conexao = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            Gerador.GeradorBinder binder = (Gerador.GeradorBinder) service;
            gerador = binder.getService();
            conectado = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            conectado = false;
        }
    };


    class NumerosReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Gerador.ACTION_NUMERO_GERADO)) {
                int numero = intent.getIntExtra("numero", -1);
                TextView edNum = findViewById(R.id.edNumero);
                edNum.setText(String.valueOf(numero));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NumerosReceiver rcvr = new NumerosReceiver();
        registerReceiver(rcvr, new IntentFilter(Gerador.ACTION_NUMERO_GERADO));
    }

    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, Gerador.class);
        bindService(intent, conexao, Context.BIND_AUTO_CREATE);
    }

    public void acelerar( View v) {
        gerador.acelerar();
    }

    public void desacelerar(View v) {
        gerador.desacelerar();
    }

    protected void onStop() {
        if (conectado) {
            gerador.parar();
        }
        unbindService( conexao );
        super.onStop();
    }
    public void gerar(View v) {
        if (conectado) {
            gerador.iniciar();
        }
    }

    public void pausar(View v) {
        if (conectado) {
            gerador.pausar();
        }
    }
}