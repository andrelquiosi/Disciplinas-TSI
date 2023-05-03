package com.example.controlecontas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener {

    private final int CAD_CONTAS = 123456;
    private EditText edCategoria;
    private ListView lista;
    private CategoriaAdapter adapter;
    int posSelecao = -1;
    boolean editando = false;

    BancoHelper helper;
    SQLiteDatabase banco;
    Cursor cursor;
    Button btnConfirmar;

    class CategoriaAdapter extends SimpleCursorAdapter {
        public CategoriaAdapter(Cursor _cursor) {
            super(getApplicationContext(),
                  R.layout.item_categoria, _cursor,
                  new String[] {"_id","descricao"},
                    new int[] { R.id.item_id_categoria, R.id.item_categoria},
                    0);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v =super.getView(position, convertView, parent);
            if (position == posSelecao) {
                v.setBackgroundColor(Color.LTGRAY);
            } else {
                v.setBackgroundColor(Color.TRANSPARENT);
            }
            return v;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        editando = true;
        posSelecao = position;
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view,
                                   int pos, long id) {
            Intent it = new Intent(MainActivity.this, CadastroConta.class);
            it.putExtra("id_categoria", id);
            Log.d("Categoria",String.valueOf(id));
            startActivityForResult(it, CAD_CONTAS);
            return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            posSelecao = savedInstanceState.getInt("posSelecao", -1);
            editando = savedInstanceState.getBoolean("editando", false);
        }
        edCategoria = (EditText) findViewById(R.id.ed_categoria);
        lista = (ListView) findViewById(R.id.lista_categorias);
        // Abrir BD e criar adapter com o Cursor
        helper = new BancoHelper(getApplicationContext());
        banco = helper.getWritableDatabase();
        cursor = banco.query("categoria",new String[] {"_id","descricao"},null, null, null, null,"descricao");
        adapter = new CategoriaAdapter(cursor);
        lista.setAdapter(adapter);
        lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lista.setOnItemClickListener(this);
        lista.setOnItemLongClickListener( this );
        btnConfirmar = (Button) findViewById(R.id.bt_confirmar);
    }

    @Override
    public void onSaveInstanceState(Bundle dados) {
        super.onSaveInstanceState(dados);
        dados.putInt("posSelecao", posSelecao);
        dados.putBoolean("editando", editando);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.main_menu, menu);
        return true;
    }

    public boolean editar(MenuItem mi) {
        if (posSelecao >= 0) {
            cursor.moveToPosition( posSelecao );
            edCategoria.setText( cursor.getString(1));
            editando = true;
            btnConfirmar.setText(R.string.confirmar);
        }
        return true;
    }

    public boolean lancar(MenuItem mi){
        int pos = lista.getCheckedItemPosition();
        if (pos >= 0) {
            Intent it = new Intent(MainActivity.this, CadastroConta.class);
            startActivityForResult(it, CAD_CONTAS);
            return true;
        } else {
            Toast.makeText(this,R.string.selecione_editar,
                    Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public void excluir(MenuItem mi){
        if (posSelecao >= 0) {
            cursor.moveToPosition( posSelecao );
            AlertDialog.Builder bld = new AlertDialog.Builder(this);
            bld.setTitle(R.string.confirmacao);
            bld.setMessage( getText(R.string.deseja_remover) + " " +
                    cursor.getString(1) + "?");
            final String[] whereParams = new String[] { cursor.getString(0) };
            bld.setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    banco.delete("conta","id_categoria = ?", whereParams); // apagar as categorias relacionadas.
                    banco.delete("categoria", "_id = ?", whereParams);
                    cursor.requery();
                    adapter.notifyDataSetChanged();
                }
            });
            bld.setCancelable( false );
            bld.setNegativeButton(R.string.nao, null);
            bld.show();
        } else {
            Toast.makeText(this,R.string.selecione_excluir,
                    Toast.LENGTH_SHORT).show();
        }
        posSelecao = -1;
    }
    public void sair(MenuItem mi){finish();}

    public void cancelar(View v) {
        if (posSelecao >= 0) {
            posSelecao = -1;
            editando = false;
            btnConfirmar.setText(R.string.adicionar);
        }
        ((EditText) findViewById(R.id.ed_categoria)).setText("");
        adapter.notifyDataSetChanged();
    }

    public void adicionar(View view){
        String texto = edCategoria.getText().toString();
        if(texto == null || texto.isEmpty()){
            Toast.makeText(this, R.string.categoria_vazia, Toast.LENGTH_SHORT).show();
        } else {
            if (posSelecao >= 0)  {
                ContentValues cv = new ContentValues();
                cv.put("descricao", texto);
                cursor.moveToPosition( posSelecao );
                banco.update("categoria",cv,"_id = ?", new String[]{ cursor.getString(0)});
                btnConfirmar.setText(R.string.adicionar);
                posSelecao = -1;
                editando = false;
                cursor.requery();
                adapter.notifyDataSetChanged();
            } else {
                ContentValues cv = new ContentValues();
                cv.put("descricao", texto);
                long id = banco.insert("categoria", null, cv);
                if (id <= 0) {
                    Toast.makeText(this,"Falha inserindo categoria.", Toast.LENGTH_LONG).show();
                } else {
                    cursor.requery();
                    adapter.notifyDataSetChanged();
                }

            }
            adapter.notifyDataSetChanged();
            edCategoria.setText("");
        }
    }
    @Override
    public void onActivityResult(int codigo, int resultado, Intent dados) {
        super.onActivityResult(codigo, resultado, dados);
        if (codigo == CAD_CONTAS && resultado == RESULT_OK)   {
            cursor.requery();
        }
        posSelecao = -1;
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        try {
            cursor.close();
            banco.close();
        } catch(Exception ex) { }
        super.onDestroy();
    }
}