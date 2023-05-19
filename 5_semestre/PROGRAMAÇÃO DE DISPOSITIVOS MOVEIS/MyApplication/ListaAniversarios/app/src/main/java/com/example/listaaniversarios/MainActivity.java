package com.example.listaaniversarios;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import com.example.listaaniversarios.dados.Aniversario;
import com.example.listaaniversarios.dados.BancoDeDados;
import com.example.listaaniversarios.dao.AniversarioDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edNome, edTelefone, edDia, edMes;
    BancoDeDados bancoDeDados;
    AniversarioDao aniversarioDao;
    ArrayAdapter<Aniversario> adapter;
    List<Aniversario> aniversarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNome = (EditText) findViewById(R.id.editTextNome);
        edTelefone = (EditText) findViewById(R.id.editTextTelefone);
        edDia = (EditText) findViewById(R.id.editTextDia);
        edMes = (EditText) findViewById(R.id.editTextMes);

        aniversarios = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, aniversarios);

        ListView lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(adapter);

        bancoDeDados = Room.databaseBuilder(getApplicationContext(), BancoDeDados.class, "aniversariantes").build();
        aniversarioDao = bancoDeDados.getAniversarioDao();
        aniversarioDao.listarTodos().observeForever(new Observador());




    }

    public void confirmar(View view) {
        try {

        new Thread() {
            public void run() {
                Looper.prepare();
                int dia = Integer.parseInt(edDia.getText().toString());
                int mes = Integer.parseInt(edMes.getText().toString());
                Aniversario aniversario = new Aniversario();
                aniversario.setNome(edNome.getText().toString());
                aniversario.setTelefone(edTelefone.getText().toString());
                aniversario.setDia(dia);
                aniversario.setMes(mes);
                long id = aniversarioDao.inserir(aniversario);

                Toast.makeText(getApplicationContext(), "Inserir com id", Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        }.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class Observador implements Observer<List<Aniversario>>{

        @Override
        public void onChanged(List<Aniversario> a) {

            aniversarios.clear();
            aniversarios.addAll(a);
            adapter.notifyDataSetChanged();

        }
    }
}