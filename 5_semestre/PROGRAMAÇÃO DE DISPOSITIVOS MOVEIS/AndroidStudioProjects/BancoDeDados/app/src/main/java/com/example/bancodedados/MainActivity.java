package com.example.bancodedados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Banco opener;
    SQLiteDatabase db;

    Cursor cursor;
    CursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opener = new Banco(getApplicationContext());
        opener.getWritableDatabase();

        db = opener.getWritableDatabase();
        cursor = db.query("categoria", new String[]{"_id","descricao"},
                "",null,null,null,"descricao");

        adapter = new SimpleCursorAdapter(this, R.layout.item_lista_categoria, cursor,new String[]{"_id","descricao"},
    new int[]{R.id.txt_id_categoria, R.id.txt_descricao_categoria});

        ListView lista = (ListView) findViewById(R.id.lista_categorias);
        lista.setAdapter(adapter);


    }

    public void confirmar (View v){
        EditText ed = (EditText) findViewById(R.id.ed_categoria);
        String categoria = ed.getText().toString();
        if(categoria.length() > 3){
            ContentValues cv = new ContentValues();
            cv.put("descricao", categoria);
            long val = db.insert("categoria", null, cv);
            Toast.makeText(this, "Inserido com _ID = " + val, Toast.LENGTH_SHORT).show();
            cursor.requery();
            adapter.notifyDataSetChanged();
            ed.setText("");
        }
    }
}