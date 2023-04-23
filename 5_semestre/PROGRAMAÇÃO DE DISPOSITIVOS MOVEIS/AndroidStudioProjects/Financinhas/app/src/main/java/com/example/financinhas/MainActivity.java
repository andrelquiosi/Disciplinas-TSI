package com.example.financinhas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    private static final int TELA_CONTAS_A_PAGAR = 123;
    private ArrayList<Categoria> categorias;
    private CategoriaAdapter adapter;
    private ListView lista;
    private Categoria categoriaEdicao = null;
    private int posicaoSelecionada = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categorias = new ArrayList<>();
        lista = (ListView) findViewById(R.id.lista_categorias);

        if (savedInstanceState != null) {
            categorias = (ArrayList<Categoria>) savedInstanceState.getSerializable("categorias");
            if (categorias == null){
                categorias = new ArrayList<>();
        }}

        adapter = new CategoriaAdapter(this, categorias);
        lista.setAdapter(adapter);
        lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lista.setOnItemLongClickListener(this);

    }

    public void onSaveInstanceState(Bundle dados){
        super.onSaveInstanceState(dados);
        dados.putSerializable("categorias",categorias);
    }

    @Override
    protected void onActivityResult(int codigo, int resultado, Intent dados) {
        super.onActivityResult(codigo, resultado, dados);

        if (codigo == TELA_CONTAS_A_PAGAR) {
            if (resultado == RESULT_OK) {

                int pos = categorias.indexOf(categoriaEdicao);
                categorias.set(pos, (Categoria) dados.getSerializableExtra("novas_despesas"));
                categoriaEdicao = null;

                adapter.notifyDataSetChanged();

            }
        }

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long id) {

        categoriaEdicao = categorias.get(pos);
        Intent it = new Intent(this, TelaContasAPagar.class);
        it.putExtra("categoria_edicao", categoriaEdicao);
        startActivityForResult(it, TELA_CONTAS_A_PAGAR);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_principal, menu);

        return true;

    }

    public void excluir(MenuItem item) {
        int pos = lista.getCheckedItemPosition();
        if (pos >= 0) {
            Categoria c = categorias.get(pos);

            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
            alertBuilder.setTitle("Confirmação");
            alertBuilder.setMessage("Deseja remover a categoria " + c.getDescricao() + " com todas as despesas?");
            alertBuilder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    categorias.remove(pos);
                    adapter.notifyDataSetChanged();
                }
            });
            alertBuilder.setCancelable(false);
            alertBuilder.setNegativeButton("Não", null);
            alertBuilder.show();
        } else {
            Toast.makeText(this, "Selecione uma categoria para remover.", Toast.LENGTH_SHORT).show();
        }
    }

    public void sair(MenuItem item) {
        finish();
    }

    public void adicionarCategoria(View view) {
        Categoria categoria = new Categoria();
        categoria.setContas(new ArrayList<>());

        String nome = ((EditText) findViewById(R.id.nomeCategoria)).getText().toString();
        int validador = nome.split(" ").length;
        if (validador <= 1) {
            categoria.setDescricao(nome);
            categorias.add(categoria);
            adapter.notifyDataSetChanged();
            ((EditText) findViewById(R.id.nomeCategoria)).setText("");
        } else {
            Toast.makeText(this, "Descreva em uma palavra.", Toast.LENGTH_SHORT).show();
        }
    }

    public class CategoriaAdapter extends ArrayAdapter<Categoria> {
        public CategoriaAdapter(Context context, ArrayList<Categoria> lista) {
            super(context, android.R.layout.simple_list_item_1, lista);
        }

        @Override
        public View getView(int posicao, View reciclada, ViewGroup grupo) {
            if (reciclada == null) {
                reciclada = getLayoutInflater().inflate(R.layout.item_categoria, null);
            }
            if (posicao == posicaoSelecionada) {
                reciclada.setBackgroundColor(Color.LTGRAY);
            } else {
                reciclada.setBackgroundColor(Color.CYAN);
            }
            Categoria categoria = categorias.get(posicao);

            ((TextView) reciclada.findViewById(R.id.item_nome_categoria)).setText(categoria.getDescricao());
            ((TextView) reciclada.findViewById(R.id.item_quantidade_despesas)).setText("" + categoria.getContas().size());
            ((TextView) reciclada.findViewById(R.id.item_valor_categoria)).setText("R$ " + categoria.getValorTotal());
            return reciclada;

        }
    }


}