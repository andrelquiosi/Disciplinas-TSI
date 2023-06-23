package com.example.listacomroom.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.listacomroom.R;
import com.example.listacomroom.adapter.ListaDeComprasAdapter;
import com.example.listacomroom.modelo.ListaDeCompras;
import com.example.listacomroom.viewModel.MainActivityViewModel;


import java.util.List;

public class MainActivity extends AppCompatActivity
        implements ListaDeComprasAdapter.HandleListaClick {

    ListaDeCompras listaDeComprasEdicao;
    private RecyclerView recyclerView;
    private MainActivityViewModel viewModelListaCompras;
    private ListaDeComprasAdapter listaDeComprasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lista_de_compras);

        getSupportActionBar().setTitle("Lista de compras");

        recyclerView = findViewById(R.id.recyclerViewLista);
        ImageView addNew = findViewById(R.id.addNewCategoryImageView);
        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddListaDeComprasDialog(false);
            }
        });
        initViewModel();
        initRecyclerView();
        viewModelListaCompras.getAllListaDeCompras();

    }

    private void initViewModel() {
        viewModelListaCompras = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModelListaCompras.getListaObserver().observe(this, new Observer<List<ListaDeCompras>>() {
            @Override
            public void onChanged(List<ListaDeCompras> listaDeCompras) {
                if (listaDeCompras == null) {
                    recyclerView.setVisibility(View.GONE);
                } else {
                    //show in the recyclerview
                    listaDeComprasAdapter.setListaDeCompras(listaDeCompras);
                    recyclerView.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listaDeComprasAdapter = new ListaDeComprasAdapter(this, this);
        recyclerView.setAdapter(listaDeComprasAdapter);
    }

    private void showAddListaDeComprasDialog(boolean isForEdit) {
        AlertDialog dialogBuilder = new AlertDialog.Builder(this).create();
        View dialogView = getLayoutInflater().inflate(R.layout.layout_adicionar_categoria, null);
        EditText enterDescricao = dialogView.findViewById(R.id.enterDescricao);
        TextView criarButton = dialogView.findViewById(R.id.criarButton);
        TextView cancelarButton = dialogView.findViewById(R.id.cancelarButton);

        if (isForEdit) {
            criarButton.setText("Atualizar");
            enterDescricao.setText(listaDeComprasEdicao.getDescricao());
        }
        cancelarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBuilder.dismiss();
            }
        });
        criarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = enterDescricao.getText().toString();
                if (TextUtils.isEmpty(nome)) {
                    Toast.makeText(MainActivity.this, "Informe o nome da lista", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (isForEdit) {
                    listaDeComprasEdicao.setDescricao(nome);
                    viewModelListaCompras.updateListaDeCompras(listaDeComprasEdicao);
                } else {
                    //here we need to call view model.
                    viewModelListaCompras.insertListaDeCompras(nome);
                }
                dialogBuilder.dismiss();
            }
        });
        dialogBuilder.setView(dialogView);
        dialogBuilder.show();
    }

    @Override
    public void itemClick(ListaDeCompras lista) {
        Intent intent = new Intent(MainActivity.this, CadProdutos.class);
        intent.putExtra("lista_id", lista.getIdCompras());
        intent.putExtra("lista_nome", lista.getDescricao());

        startActivity(intent);
    }

    @Override
    public void removeItem(ListaDeCompras lista) {
        viewModelListaCompras.deleteListaDeCompras(lista);
    }

    @Override
    public void editaItem(ListaDeCompras lista) {
        this.listaDeComprasEdicao = lista;
        showAddListaDeComprasDialog(true);

    }
}