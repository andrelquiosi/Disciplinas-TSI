package com.example.buscacep;

import android.app.IntentService;
import android.content.Intent;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ServicoCEP extends IntentService {

    Gson gson;
    public ServicoCEP()
    {
        super("ServicoCEP");
        GsonBuilder bld = new GsonBuilder();
        // configurações aqui!
        gson = bld.create();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String cep = intent.getStringExtra("CEP");
            String endereco = "https://viacep.com.br/ws/"+cep+"/json";
            try {
                URL ender = new URL(endereco);
                HttpsURLConnection conn = (HttpsURLConnection) ender.openConnection();
                InputStream is = conn.getInputStream();
                BufferedReader reader = new BufferedReader( new InputStreamReader(is) );
                String linha;
                StringBuilder bld = new StringBuilder(1000);
                do {
                    linha = reader.readLine();
                    if (linha != null) {
                        bld.append(linha);
                    }
                } while(linha != null);
                CEP objeto = gson.fromJson(bld.toString(), CEP.class);
                Intent resp = new Intent("TERMINOU_CONSULTA_CEP");
                resp.putExtra("cep", objeto);
                sendBroadcast( resp );
            } catch(Throwable t) {
                t.printStackTrace();
            }
        }
    }
}