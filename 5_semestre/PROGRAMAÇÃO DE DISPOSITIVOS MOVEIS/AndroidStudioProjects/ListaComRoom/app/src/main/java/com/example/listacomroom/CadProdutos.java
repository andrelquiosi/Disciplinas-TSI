package com.example.listacomroom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.listacomroom.modelo.Produto;
import com.example.listacomroom.modelo.Setor;
import com.example.listacomroom.viewModel.MostrarListProdutosActivityViewModel;

import java.util.List;

public class CadProdutos extends AppCompatActivity implements ListaProdutosAdapter.HandleProdutosClick
{

    private long lista_id;
    private ListaProdutosAdapter listaProdutosAdapter;
    private MostrarListProdutosActivityViewModel viewModelProdutos;
    private RecyclerView recyclerView;
    private Produto atualizaProduto = null;
    Setor depto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_produtos);
        recyclerView = findViewById(R.id.recyclerViewProdutos);

        lista_id = getIntent().getLongExtra("lista_id", 0);
        String listaNome = getIntent().getStringExtra("lista_nome");

        getSupportActionBar().setTitle(listaNome);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView salvarButton = findViewById(R.id.SalvarButton);
        salvarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prod = ((EditText) findViewById(R.id.ed_produto)).getText().toString();
                double qtde;
                if(TextUtils.isEmpty(prod)) {
                    Toast.makeText(CadProdutos.this, "Informe o nome", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(((EditText) findViewById(R.id.ed_qtde)).getText().toString())) {
                    Toast.makeText(CadProdutos.this, "Informe a quantidade", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    qtde = Double.parseDouble(
                            ((EditText) findViewById(R.id.ed_qtde)).getText().toString());
                }
                if(atualizaProduto == null)
                    salvarNovoProduto(prod, qtde);
                else
                    atualizarNovoProduto(prod, qtde);
            }
        });
        initViewModel();
        initRecyclerView();
        viewModelProdutos.getAllProdutoList(lista_id);
    }
    private void initViewModel() {
        viewModelProdutos = new ViewModelProvider(this).get(MostrarListProdutosActivityViewModel.class);
        viewModelProdutos.getProdutoListObserver().observe(this, new Observer<List<Produto>>() {
            @Override
            public void onChanged(List<Produto> produtos) {
                if(produtos == null) {
                    recyclerView.setVisibility(View.GONE);
                } else {
                    listaProdutosAdapter.setCategoryList(produtos);
                    recyclerView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listaProdutosAdapter = new ListaProdutosAdapter(this, this);
        recyclerView.setAdapter(listaProdutosAdapter);
    }
    private void salvarNovoProduto(String prod, double qtde) {
        Produto produto = new Produto();
        Setor setor = new Setor("bebidas");
        produto.setDescricao(prod);
        produto.setQuantidade(qtde);
        produto.setIdLista(lista_id);
        produto.setIdSetor(setor.getIdSetor());
        viewModelProdutos.inserirProdutos(produto);
        ((EditText) findViewById(R.id.ed_produto)).setText("");
        ((EditText) findViewById(R.id.ed_qtde)).setText("");
    }
    private void atualizarNovoProduto(String prod, double qtde) {

        atualizaProduto.setDescricao(prod);
        atualizaProduto.setQuantidade(qtde);

        viewModelProdutos.atualizarProdutos(atualizaProduto);
        ((EditText) findViewById(R.id.ed_produto)).setText("");
        ((EditText) findViewById(R.id.ed_qtde)).setText("");
        atualizaProduto = null;
    }

    @Override
    public void produtoClick(Produto produto) {
        if(produto.isComprado()) {
            produto.setComprado(false);
        }
        else {
            produto.setComprado(true);
        }
        viewModelProdutos.atualizarProdutos(produto);
    }

    @Override
    public void removeProduto(Produto produto) {
        viewModelProdutos.deleteProduto(produto);
    }

    @Override
    public void editarProduto(Produto produto) {
        this.atualizaProduto = produto;
        ((EditText) findViewById(R.id.ed_produto)).setText(produto.getDescricao());

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}