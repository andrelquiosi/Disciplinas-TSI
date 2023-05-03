package com.example.consultacep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buscarCEP( View v ) {
        EditText ed = (EditText) findViewById(R.id.edCEP);
        String cep = ed.getText().toString();
        if (cep.trim().length() == 8) {
            new Buscador().execute(cep);
        }
    }

    class Buscador extends AsyncTask<String, Void, Map> {

        @Override
        protected Map doInBackground(String... strings) {
            String cep = strings[0];
            try {
                URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
                HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                conn.connect();
                if (conn.getResponseCode() == 200) {
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()));
                    String resp = "";
                    String linha;
                    do {
                        linha = reader.readLine();
                        if (linha != null) {
                            resp += linha;
                        }
                    } while ( linha != null);
                    Log.d("resp:", resp);
                    Gson gson = new GsonBuilder().create();
                    Map m = gson.fromJson( resp, Map.class);
                    return m;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return null;
        }

        @Override
        public void onPostExecute(Map m) {
            EditText resp = (EditText) findViewById(R.id.resultado);
            if (m.containsKey("erro")) {
                resp.setText("CEP não encontrado!");
            } else {
                resp.setText("Localidade: "+m.get("localidade")+
                        "\nLogradouro: " + m.get("logradouro"));
            }
        }
    }
}