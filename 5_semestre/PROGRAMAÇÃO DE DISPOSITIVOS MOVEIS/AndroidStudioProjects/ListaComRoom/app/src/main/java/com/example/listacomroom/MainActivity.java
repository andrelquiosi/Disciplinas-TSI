package com.example.listacomroom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listacomroom.banco.Banco;
import com.example.listacomroom.banco.SetorDAO;
import com.example.listacomroom.modelo.Setor;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemLongClickListener {

    EditText edNome;
    ListView lwDeptos;
    ArrayAdapter adapter;
    Banco bd;
    SetorDAO deptoDAO;
    List<Setor> listaDeptos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edNome = (EditText) findViewById(R.id.edDepartamento);
        lwDeptos = (ListView) findViewById(R.id.departamentos);
        bd = Room.databaseBuilder( getApplicationContext(), Banco.class,
                "lista_compras").allowMainThreadQueries().build();
        deptoDAO = bd.getSetorDAO();
        listarDeptos();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice,
                        listaDeptos);
        lwDeptos.setAdapter( adapter );
        lwDeptos.setOnItemLongClickListener( this );
    }

    public void inserir( View v) {
        String nome = edNome.getText().toString();
        Setor dp = new Setor( nome );
        deptoDAO.inserir( dp );
        listarDeptos();
        adapter.notifyDataSetChanged();
        edNome.setText("");
    }

    public void listarDeptos() {
        if (listaDeptos == null) {
            listaDeptos = new ArrayList<>(200);
        } else {
            listaDeptos.clear();
        }
        List<Setor> lst = deptoDAO.buscarTodos();
        listaDeptos.addAll(lst);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        Setor dpto = listaDeptos.get(i);
        Intent it = new Intent( this, CadProdutos.class);
        it.putExtra("idDepto", dpto.getIdSetor());
        startActivity( it );
        return true;
    }

    private void showAddCategoryDialog(boolean isForEdit) {
        AlertDialog dialogBuilder = new AlertDialog.Builder(this).create();
        View dialogView = getLayoutInflater().inflate( R.layout.add_category_layout, null);
        EditText enterCategoryInput = dialogView.findViewById(R.id.enterCategoryInput);
        TextView createButton = dialogView.findViewById(R.id.createButton);
        TextView cancelButton = dialogView.findViewById(R.id.cancelButton);

        if(isForEdit){
            createButton.setText("Update");
            enterCategoryInput.setText(categoryForEdit.categoryName);
        }
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBuilder.dismiss();
            }
        });
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = enterCategoryInput.getText().toString();
                if(TextUtils.isEmpty(name)) {
                    Toast.makeText(MainActivity.this, "Enter category name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(isForEdit){
                    categoryForEdit.categoryName = name;
                    viewModel.updateCategory(categoryForEdit);
                } else {
                    //here we need to call view model.
                    viewModel.insertCategory(name);
                }
                dialogBuilder.dismiss();
            }
        });
        dialogBuilder.setView(dialogView);
        dialogBuilder.show();
    }

}