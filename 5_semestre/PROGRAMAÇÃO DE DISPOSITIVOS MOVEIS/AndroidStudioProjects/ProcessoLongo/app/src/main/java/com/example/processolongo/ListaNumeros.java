package com.example.processolongo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaNumeros extends AppCompatActivity {

    ArrayAdapter adapter;
    ListView lista;

    ArrayList<Integer> numeros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_numeros);
        lista = (ListView) findViewById(R.id.lista_numeros);
        numeros = getIntent().getIntegerArrayListExtra("lista");
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, numeros);
        lista.setAdapter(adapter);
    }
}