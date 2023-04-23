package com.example.contatos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    public final int TELA_CONTATO = 9876;
    private ArrayList<Contato> contatos;
    private ArrayAdapter<Contato> adapter;
    private ListView lista;
    private Contato contatoEdicao = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contatos = new ArrayList<>();
        lista = (ListView) findViewById(R.id.lista);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, contatos);
        lista.setAdapter( adapter );
        lista.setChoiceMode( ListView.CHOICE_MODE_SINGLE );
        lista.setOnItemLongClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate( R.menu.menu_principal, menu );

        return true;

    }

    public void adicionar(MenuItem mi){
        Intent it = new Intent(this, TelaContato.class);
        startActivityForResult( it,  TELA_CONTATO );
    }
    public void excluir(MenuItem mi){
        int pos = lista.getCheckedItemPosition();
        if (pos >= 0){
            Contato c = contatos.get(pos);

            AlertDialog.Builder bld = new AlertDialog.Builder(this);
            bld.setTitle("Confirmação");
            bld.setMessage("Deseja realmente remover o contato de "+ c.getNome()+"?");
            bld.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    contatos.remove(pos);
                    adapter.notifyDataSetChanged();
                }
            });
            bld.setCancelable(false);
            bld.setNegativeButton("Não", null);
            bld.show();
        }else {
            Toast.makeText(this, "Selecione o contato a remover.", Toast.LENGTH_SHORT).show();
        }
    }
    public void sair(MenuItem mi){
        finish();
    }


    @Override
    protected void onActivityResult(int codigo, int resultado, Intent dados) {
        super.onActivityResult(codigo, resultado, dados);

        if (codigo == TELA_CONTATO){
            if (resultado == RESULT_CANCELED){

                Toast.makeText(this, "Usuário cancelou...", Toast.LENGTH_SHORT).show();
                contatoEdicao = null;

            }else if (resultado == RESULT_OK){

                Contato novo = (Contato) dados.getSerializableExtra("novo_contato");
                if (contatoEdicao == null){

                    contatos.add(novo);
                }else {
                    int pos = contatos.indexOf( contatoEdicao );
                    contatos.set(pos, novo);
                    contatoEdicao = null;
                }
                adapter.notifyDataSetChanged();

            }
        }

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long id) {
        contatoEdicao = contatos.get(pos);
        Intent it = new Intent(this, TelaContato.class);
        it.putExtra("contato_edicao", contatoEdicao);
        startActivityForResult(it, TELA_CONTATO);
        return  true;
    }
}