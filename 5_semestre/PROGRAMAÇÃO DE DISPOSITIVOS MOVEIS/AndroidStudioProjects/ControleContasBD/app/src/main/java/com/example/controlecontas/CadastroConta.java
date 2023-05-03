package com.example.controlecontas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CadastroConta extends AppCompatActivity
implements AdapterView.OnItemClickListener {


    ListView lista;
    EditText edDescicao, edValor, edVencimento;
    ContasAdapter adapter;
    Date dataVencimento;
    long ed;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    int posSelecionada = -1;
    Button btConfirmar;
    boolean editando = false;
    SQLiteDatabase banco;
    Cursor cursor;
    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
        if (!editando) {
            if (position == posSelecionada) {
                posSelecionada = -1;
            } else {
                posSelecionada = position;
            }
        }
        adapter.notifyDataSetChanged();
    }

    class ContasAdapter extends SimpleCursorAdapter {
        public ContasAdapter(Cursor cursor) {
            super(getApplicationContext(), R.layout.item_conta, cursor,
                    new String[] {"descricao", "vencimento", "valor"},
                    new int[] {R.id.item_conta, R.id.item_vencimento, R.id.item_valor},0);
        }
        @Override
        public View getView(int posicao, View reciclada, ViewGroup grupo) {
            View v = super.getView(posicao, reciclada, grupo);
            // Ajustar o campo de data para formatação
            long dt = cursor.getLong(2); // ver a posição no select => query(...)
            String data = sdf.format( new Date( dt ));
            ((TextView) v.findViewById(R.id.item_vencimento)).setText( data );
            v.setBackgroundColor((posicao == posSelecionada) ? Color.LTGRAY : Color.TRANSPARENT);
            return v;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_conta);
        edDescicao = (EditText) findViewById(R.id.ed_descricao);
        edValor = (EditText) findViewById(R.id.ed_valor);
        edVencimento = (EditText) findViewById(R.id.ed_vecimento);
        Intent it = getIntent();
        ed = it.getLongExtra("id_categoria", 0);
        lista = (ListView) findViewById(R.id.lista_contas);
        BancoHelper hlp = new BancoHelper(getApplicationContext());
        banco = hlp.getWritableDatabase();
        cursor = banco.query("conta",
                new String[] {"_id","descricao","vencimento","valor"},
                " id_categoria = ?",
                new String[] { String.valueOf(ed) },
                null, null, "descricao");
        adapter = new ContasAdapter(cursor);
        lista.setAdapter(adapter);
        lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lista.setOnItemClickListener( this);
        btConfirmar = (Button) findViewById(R.id.bt_confirmar);
    }

    @Override
    public void onSaveInstanceState(Bundle dados) {
        super.onSaveInstanceState(dados);
        dados.putSerializable("ed",ed);
    }

    public void adicionar(View view){
        String descr = edDescicao.getText().toString();
        String vlr = edValor.getText().toString();
        String vcto = edVencimento.getText().toString();
        Date data = null;
        double valor = -1;
        try {
            valor = Double.parseDouble( vlr );
            data = sdf.parse(vcto);
        } catch (ParseException pe) {
            vlr = "";
            vcto = "";
        }
        if(descr.isEmpty() || vlr.isEmpty() || vcto.isEmpty()){
            Toast.makeText(this,R.string.preencha_campos,Toast.LENGTH_LONG).show();
        } else {
            ContentValues cv = new ContentValues();
            cv.put("descricao", descr);
            cv.put("valor", valor);
            cv.put("vencimento", data.getTime());
            if (editando) {
                cursor.moveToPosition( posSelecionada);
                banco.update("conta", cv, "_id = ?", new String[]{cursor.getString(0)});
                editando = false;
            } else {
                cv.put("id_categoria", ed);
                long id = banco.insert("conta", null, cv);
                if (id <= 0) {
                    Toast.makeText(this, "Erro inserindo conta", Toast.LENGTH_LONG).show();
                    return;
                }
            }
            edDescicao.setText("");
            edValor.setText("");
            edVencimento.setText("");
            posSelecionada = -1;
            editando = false;
            cursor.requery();
            adapter.notifyDataSetChanged();
            btConfirmar.setText(R.string.adicionar);
        }
    }

    public void cancelar(View v) {
        edDescicao.setText("");
        edValor.setText("");
        edVencimento.setText("");
        posSelecionada = -1;
        editando = false;
        btConfirmar.setText(R.string.adicionar);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.contas_menu, menu);
        return true;
    }

    public void editar(MenuItem mi){
        if (posSelecionada >= 0) {
            cursor. moveToPosition( posSelecionada );
            ((EditText) findViewById(R.id.ed_descricao)).setText( cursor.getString(1) );
            ((EditText) findViewById(R.id.ed_valor)).setText( cursor.getString(3) );
            ((EditText) findViewById(R.id.ed_vecimento)).setText(sdf.format(new Date(cursor.getLong(2))));
            editando = true;
            btConfirmar.setText(R.string.confirmar);
        } else {
            Toast.makeText(this,R.string.selecione_editar, Toast.LENGTH_SHORT).show();
        }
    }
    public void voltar(MenuItem mi){
        Intent intent = new Intent();
        intent.putExtra("categoria", ed);
        setResult(RESULT_OK, intent);
        finish();
    }
    public void excluir(MenuItem mi){
        if (posSelecionada >= 0) {
            cursor.moveToPosition( posSelecionada );
            AlertDialog.Builder bld = new AlertDialog.Builder(this);
            bld.setTitle(R.string.confirmacao);
            bld.setMessage( getText( R.string.deseja_remover ) +" "+
                    cursor.getString(1)+"?");
            String[] whereParams = new String[] { cursor.getString(0) };
            bld.setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    banco.delete("conta","_id = ?", whereParams);
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
    }

    public void selecionarData(View v){

        DatePickerDialog dlgData = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            dlgData = new DatePickerDialog(this);
            dlgData.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int ano, int mes, int dia) {
                    Calendar cal = Calendar.getInstance();
                    cal.set(Calendar.YEAR, ano);
                    cal.set(Calendar.MONTH, mes);
                    cal.set(Calendar.DAY_OF_MONTH, dia);
                    dataVencimento = cal.getTime();
                    edVencimento.setText(sdf.format(dataVencimento));
                }
            });
            dlgData.show();
        }
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