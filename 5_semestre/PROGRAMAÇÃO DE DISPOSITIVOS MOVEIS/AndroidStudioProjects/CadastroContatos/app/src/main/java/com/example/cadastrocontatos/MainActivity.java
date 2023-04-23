package com.example.cadastrocontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contato> contatos;

    CadastroFragment fragCadastro;
    ListaFragment fragLista;

    Contato editando = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragCadastro = (CadastroFragment) getFragmentManager().findFragmentByTag("fragContato");
        fragLista = (ListaFragment) getFragmentManager().findFragmentByTag("fragLista");
        if (savedInstanceState != null) {
            contatos = (ArrayList<Contato>) savedInstanceState.getSerializable("listaContatos");
        }
        if (contatos == null) {
            contatos = new ArrayList<Contato>(50);
        }
        fragLista.setContatos( contatos );
    }

    @Override
    public void onSaveInstanceState(Bundle bld) {
        super.onSaveInstanceState(bld);
        bld.putSerializable( "listaContatos", contatos );
    }

    public void confirmar(View v) {
        if (fragCadastro != null) {
            Contato c = fragCadastro.validarDados();
            if (c != null) {
                if (editando != null) {
                    fragLista.substituir(editando, c);
                } else {
                    fragLista.adicionar(c);
                }
                Log.d("CONTATO", "Adicionado");
                editando = null;
            }
        }
    }

    public void editar(View v) {
        if (fragLista != null) {
            Contato c = fragLista.getContatoSelecionado();
            if (c == null) {
                Toast.makeText(this,"Selecione o contato a editar", Toast.LENGTH_SHORT).show();
            } else {
                fragCadastro.ajustarEdicao( c );
                editando = c;
            }
        }
    }

    public void remover(View v) {
        if (fragLista != null) {
            fragLista.remover();
        }
    }
}