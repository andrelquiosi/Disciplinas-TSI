package com.example.listacomroom.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listacomroom.R;
import com.example.listacomroom.adapter.SetorAdapter;
import com.example.listacomroom.modelo.Setor;
import com.example.listacomroom.viewModel.CadastroSetoresViewModel;

import java.util.List;


public class CadastroSetores extends AppCompatActivity
implements SetorAdapter.HandleListaClick{
    private RecyclerView recyclerView;
    CadastroSetoresViewModel viewModelSetor;
    SetorAdapter setorAdapter;
    Setor setorEdicao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_setores);

        getSupportActionBar().setTitle("Lista de Setores");

        recyclerView = findViewById(R.id.recyclerViewSetor);
        ImageView addNew = findViewById(R.id.addNewSetorImageView);
        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddSetorDialog(false);
            }
        });
        initViewModel();
        initRecyclerView();
        viewModelSetor.getAllSetor();
    }
    private void initViewModel() {
        viewModelSetor = new ViewModelProvider(this).get(CadastroSetoresViewModel.class);
        viewModelSetor.getListaObserver().observe(this, new Observer<List<Setor>>() {
            @Override
            public void onChanged(List<Setor> setores) {
                if (setores == null) {
                    recyclerView.setVisibility(View.GONE);
                } else {
                    //show in the recyclerview
                    setorAdapter.setSetor(setores);
                    recyclerView.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setorAdapter = new SetorAdapter(this, this);
        recyclerView.setAdapter(setorAdapter);
    }
    private void showAddSetorDialog(boolean isForEdit) {
        AlertDialog dialogBuilder = new AlertDialog.Builder(this).create();
        View dialogView = getLayoutInflater().inflate(R.layout.layout_adicionar_categoria, null);
        EditText enterDescricao = dialogView.findViewById(R.id.enterDescricao);
        TextView criarButton = dialogView.findViewById(R.id.criarButton);
        TextView cancelarButton = dialogView.findViewById(R.id.cancelarButton);

        if (isForEdit) {
            criarButton.setText("Atualizar");
            enterDescricao.setText(setorEdicao.getDescricao());
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
                    Toast.makeText(CadastroSetores.this, "Imforme o ome do Setor", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (isForEdit) {
                    setorEdicao.setDescricao(nome);
                    viewModelSetor.updateSetor(setorEdicao);
                } else {
                    //here we need to call view model.
                    viewModelSetor.insertSetor(nome);
                }
                dialogBuilder.dismiss();
            }
        });
        dialogBuilder.setView(dialogView);
        dialogBuilder.show();
    }

        @Override
    public void removeItem(Setor setor) {
    viewModelSetor.deleteSetor(setor);
    }

    @Override
    public void editaItem(Setor setor) {
        this.setorEdicao = setor;
        showAddSetorDialog(true);

    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.activety_setor_menu, menu);

        return true;

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}