package com.example.listacomroom.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listacomroom.R;
import com.example.listacomroom.adapter.ListaProdutosAdapter;
import com.example.listacomroom.modelo.Produto;
import com.example.listacomroom.modelo.Setor;
import com.example.listacomroom.viewModel.CadastroSetoresViewModel;
import com.example.listacomroom.viewModel.MostrarListProdutosActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class CadProdutos extends AppCompatActivity implements ListaProdutosAdapter.HandleProdutosClick {

    private long lista_id;
    private ListaProdutosAdapter listaProdutosAdapter;
    private MostrarListProdutosActivityViewModel viewModelProdutos;
    private RecyclerView recyclerView;
    private Produto atualizaProduto = null;
    private ArrayAdapter<Setor> spinnerAdapter;
    private ArrayList<Setor> setores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_produtos);
        recyclerView = findViewById(R.id.recyclerViewProdutos);

        lista_id = getIntent().getLongExtra("lista_id", 0);
        String listaNome = getIntent().getStringExtra("lista_nome");

        spinner();

        getSupportActionBar().setTitle(listaNome);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView salvarButton = findViewById(R.id.SalvarButton);
        salvarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prod = ((EditText) findViewById(R.id.ed_produto)).getText().toString();
                double qtde;
                if (TextUtils.isEmpty(prod)) {
                    Toast.makeText(CadProdutos.this, "Informe o nome", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(((EditText) findViewById(R.id.ed_qtde)).getText().toString())) {
                    Toast.makeText(CadProdutos.this, "Informe a quantidade", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    qtde = Double.parseDouble(
                            ((EditText) findViewById(R.id.ed_qtde)).getText().toString());
                }
                if (atualizaProduto == null)
                    salvarNovoProduto(prod, qtde, 2);
                else
                    atualizarNovoProduto(prod, qtde, 2);
            }
        });
        initViewModel();
        initRecyclerView();
        viewModelProdutos.getAllProdutoList(lista_id);

    }

    private void spinner() {

        setores = new ArrayList<>();
        Spinner spinner = (Spinner) findViewById(R.id.setores);
        spinnerAdapter = new ArrayAdapter<Setor>(this, android.R.layout.simple_spinner_item, setores);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

    }

    private void initViewModel() {
        viewModelProdutos = new ViewModelProvider(this).get(MostrarListProdutosActivityViewModel.class);
        viewModelProdutos.getProdutoListObserver().observe(this, new Observer<List<Produto>>() {
            @Override
            public void onChanged(List<Produto> produtos) {
                if (produtos == null) {
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

    private void salvarNovoProduto(String prod, double qtde, long setor) {
        Produto produto = new Produto();
        produto.setDescricao(prod);
        produto.setQuantidade(qtde);
        produto.setIdLista(lista_id);
        produto.setIdSetor(setor);
        viewModelProdutos.inserirProdutos(produto);
        ((EditText) findViewById(R.id.ed_produto)).setText("");
        ((EditText) findViewById(R.id.ed_qtde)).setText("");
    }

    private void atualizarNovoProduto(String prod, double qtde, long setor) {

        atualizaProduto.setDescricao(prod);
        atualizaProduto.setQuantidade(qtde);
        atualizaProduto.setIdSetor(setor);

        viewModelProdutos.atualizarProdutos(atualizaProduto);
        ((EditText) findViewById(R.id.ed_produto)).setText("");
        ((EditText) findViewById(R.id.ed_qtde)).setText("");
        atualizaProduto = null;
    }

    @Override
    public void produtoClick(Produto produto) {
        produto.setComprado(!produto.isComprado());
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

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
            case R.id.itemMenuSetor:

                startActivity(new Intent(this, CadastroSetores.class));

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.activety_setor_menu, menu);

        return true;

    }
}
