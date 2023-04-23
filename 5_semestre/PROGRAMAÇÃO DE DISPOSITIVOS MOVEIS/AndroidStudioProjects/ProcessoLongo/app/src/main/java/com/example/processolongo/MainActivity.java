package com.example.processolongo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Contagem at;
    EditText edNums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "CANAL_01";
            String description = "Canal de notificações deste APP.";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("TESTE", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edNums = (EditText) findViewById(R.id.edNumeros);
    }

    public void iniciar(View v) {
        if (at == null) {
            try {
                int num = Integer.parseInt( edNums.getText().toString() );
               /* Inicia o AssyncTask COntagem
                at = new Contagem();
                at.execute(new Integer(num) );
                */
                Intent it = new Intent(this,GeradorNumeros.class);
                it.putExtra("quantidade", num);
                startService(it);
                edNums.setText("");
            } catch(NumberFormatException ex) {
                Toast.makeText(this,"Informe uma quantidade de números", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this,"Aguarde a geração atual terminar!", Toast.LENGTH_SHORT).show();
        }
    }


    class Contagem extends AsyncTask<Integer, Integer, List<Integer>> {

        @Override
        protected List<Integer> doInBackground(Integer... integers) {
            int i = integers[0];
            List<Integer> numeros = new ArrayList<Integer>();
            Random r = new Random();
            while ( i > 0) {
                numeros.add(r.nextInt(10000));
                i--;
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                publishProgress( i );
            }
            return numeros;
        }

        @Override
        protected void onProgressUpdate( Integer... val) {
            TextView tv = findViewById( R.id.clk );
            tv.setText( val[0].toString() );
        }

        @Override
        protected void onPostExecute(List<Integer> lst ) {
            // Criando uma PendingIntent, que será executada quando clicar na notificação.
            ArrayList<Integer> lista = (ArrayList<Integer>) lst;
            Intent intent = new Intent(MainActivity.this, ListaNumeros.class);
            intent.putIntegerArrayListExtra("lista", lista );
            PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

            // Configurando a notificação
            NotificationCompat.Builder bld = new NotificationCompat.Builder( MainActivity.this, "TESTE");
            bld.setContentTitle("Terminou");
            bld.setContentText("A geração dos números terminou.\nClique para ver o resultado");
            bld.setSmallIcon(R.mipmap.ic_launcher_round);
            bld.setContentIntent(pendingIntent);
            bld.setAutoCancel(true);

            // Recuperando o NotificationManager e gerando a notificação
            NotificationManager nmc = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            nmc.notify(12313, bld.build() );

            at = null;
        }
    }
}