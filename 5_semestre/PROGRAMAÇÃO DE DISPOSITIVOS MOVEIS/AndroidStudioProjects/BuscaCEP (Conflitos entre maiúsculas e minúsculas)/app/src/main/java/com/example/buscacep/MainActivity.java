package com.example.buscacep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    class OuvinteCEP extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                CEP resp = (CEP) intent.getSerializableExtra("cep");
                if (! resp.isErro()) {
                    (((TextView) findViewById(R.id.txt_cep)))
                            .setText(resp.getCep());
                    (((TextView) findViewById(R.id.txt_localidade)))
                            .setText(resp.getLocalidade());
                    (((TextView) findViewById(R.id.txt_logradouro)))
                            .setText(resp.getLogradouro());
                    (((TextView) findViewById(R.id.txt_complemento)))
                            .setText(resp.getComplemento());
                    (((TextView) findViewById(R.id.txt_bairro)))
                            .setText(resp.getBairro());
                    (((TextView) findViewById(R.id.txt_ddd)))
                            .setText(resp.getDdd());
                    (((TextView) findViewById(R.id.txt_uf)))
                            .setText(resp.getUf());
                } else {
                    Toast.makeText(getApplicationContext(),
                            "CEP informado não foi encontrado!",
                            Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver( new OuvinteCEP(),
                new IntentFilter("TERMINOU_CONSULTA_CEP"));
    }

    public void buscar(View v) {
        String cep = ((EditText) findViewById(R.id.ed_cep))
                         .getText().toString();
        if (cep.length() < 8) {
            Toast.makeText(this,"Informe CEP (apenas números) completo",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        (((TextView) findViewById(R.id.txt_cep))).setText("");
        (((TextView) findViewById(R.id.txt_localidade))).setText("");
        (((TextView) findViewById(R.id.txt_logradouro))).setText("");
        (((TextView) findViewById(R.id.txt_complemento))).setText("");
        (((TextView) findViewById(R.id.txt_bairro))).setText("");
        (((TextView) findViewById(R.id.txt_ddd))).setText("");
        (((TextView) findViewById(R.id.txt_uf))).setText("");
        Intent it = new Intent(this, ServicoCEP.class);
        it.putExtra("CEP", cep);
        startService( it );
    }
}