package com.example.clienterest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.clienterest.model.Produto;
import com.example.clienterest.model.Setor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gson = new GsonBuilder().create();
    }

    public void inserir(View v) {
        String descricao = ((EditText) findViewById(R.id.edSetor)).getText().toString();
        double margem = Double.parseDouble(((EditText) findViewById(R.id.edMargem)).getText().toString());
        Setor s = new Setor(0, descricao, margem);
        final String json = gson.toJson( s );
        new Thread() {
            public void run(){
                Looper.prepare();
                try {
                    URL url = new URL("http://argo.td.utfpr.edu.br/clients/ws/setor");
                    HttpURLConnection cnx = (HttpURLConnection) url.openConnection();
                    cnx.setRequestMethod("POST");
                    cnx.setRequestProperty("Content-Type","application/json");
                    PrintWriter saida = new PrintWriter( cnx.getOutputStream() );
                    saida.println(json);
                    saida.flush();
                    cnx.connect();
                    if (cnx.getResponseCode() == 201){
                        Toast.makeText(getApplicationContext(),
                                "Setor cadastrado com sucesso!",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Falha no cadastro do setor.",
                                Toast.LENGTH_LONG).show();
                    }
                } catch (Throwable t) {
                    t.printStackTrace();
                }
                Looper.loop();
            }
        }.start();
    }
 }