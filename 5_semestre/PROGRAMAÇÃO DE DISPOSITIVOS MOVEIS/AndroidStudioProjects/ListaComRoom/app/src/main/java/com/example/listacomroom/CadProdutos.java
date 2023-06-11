package com.example.listacomroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.listacomroom.banco.Banco;
import com.example.listacomroom.banco.SetorDAO;
import com.example.listacomroom.banco.ProdutoDAO;
import com.example.listacomroom.modelo.ListaComProdutos;
import com.example.listacomroom.modelo.Setor;
import com.example.listacomroom.modelo.Produto;

import java.util.ArrayList;
import java.util.List;

public class CadProdutos extends AppCompatActivity implements
        AdapterView.OnItemLongClickListener {

    Setor depto;
    SetorDAO deptoDAO;
    ProdutoDAO produtoDAO;
    Banco bd;
    ListaComProdutos deptoProds;
    ArrayAdapter adapter;
    List<Produto> produtos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_produtos);
        long idDepto = getIntent().getLongExtra("idDepto", 0);
        bd = Room.databaseBuilder( getApplicationContext(), Banco.class,
                "lista_compras").build();
        deptoDAO = bd.getSetorDAO();
        produtoDAO = bd.getProdutoDAO();
        deptoDAO.buscarPorId( (int) idDepto ).observeForever( new Atualizador() );

        produtos = new ArrayList<>();
        adapter = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_single_choice,
                produtos);
        ListView lv = ((ListView) findViewById(R.id.lista_prods));
        lv.setAdapter(adapter);
        lv.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        lv.setOnItemLongClickListener(this);
    }

    public void confirmar(View v) {
        String prod = ((EditText) findViewById(R.id.ed_produto)).getText().toString();
        double qtde = Double.parseDouble(
                ((EditText) findViewById(R.id.ed_qtde)).getText().toString());
        new Thread() {
            public void run() {
                Looper.prepare();
                Produto p = new Produto(prod, qtde, deptoProds.getListaDeCompras().getIdProduto(),1);
                produtoDAO.inserir(p);
                Looper.loop();
            }
        }.start();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView,
                                   View view, int i, long l) {
        Produto p = produtos.get(i);
        p.setComprado( ! p.isComprado() );
        new Thread() {
            public void run() {
                Looper.prepare();
                produtoDAO.atualizar( p );
                Looper.loop();
            }
        }.start();
        return true;
    }

    class Atualizador implements Observer<ListaComProdutos> {
        @Override
        public void onChanged(ListaComProdutos listaComProdutos) {
            ((TextView) findViewById(R.id.txt_depto)).setText(
                    listaComProdutos.getListaDeCompras().getDescricao() );
            deptoProds = listaComProdutos;
            produtos.clear();
            produtos.addAll( listaComProdutos.getProdutos() );
            adapter.notifyDataSetChanged();
        }
    }
}