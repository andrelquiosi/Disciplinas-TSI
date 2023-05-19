package com.example.trabalho2.viw;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalho2.R;
import com.example.trabalho2.control.PedidosAPI;
import com.example.trabalho2.control.RetrofitClientes;
import com.example.trabalho2.control.RetrofitPedidos;
import com.example.trabalho2.model.ItemPedido;
import com.example.trabalho2.model.Pedido;
import com.example.trabalho2.model.Produto;
import com.example.trabalho2.model.Setor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PedidoActivity extends AppCompatActivity {

    private Spinner spinnerSetor;
    private Spinner spinnerProduto;
    private EditText editTextQuantidade;
    private Button buttonAdicionar;
    private ListView listViewItensPedido;
    private EditText editTextCpf;
    private EditText editTextVendedor;
    private EditText editTextPercentual;
    private Button buttonEnviarPedido;
    private Button buttonAlterar;
    private Button buttonRemover;

    private List<Setor> setores;
    private List<Produto> produtos;
    private List<ItemPedido> itensPedido;
    private ArrayAdapter<Setor> setorAdapter;
    private ArrayAdapter<Produto> produtoAdapter;
    private ItensAdapter itensPedidoAdapter;

    private PedidosAPI pedidosAPI;
    Date data;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        pedidosAPI = RetrofitPedidos.getInstance().getMyApi();

        spinnerSetor = findViewById(R.id.spinnerSetor);
        spinnerProduto = findViewById(R.id.spinnerProduto);
        editTextQuantidade = findViewById(R.id.editTextQuantidade);
        buttonAdicionar = findViewById(R.id.buttonAdicionar);
        listViewItensPedido = findViewById(R.id.listViewItensPedido);
        editTextCpf = findViewById(R.id.editTextCpf2);
        editTextVendedor = findViewById(R.id.editTextVendedor);
        editTextPercentual = findViewById(R.id.editTextPercentual);
        buttonEnviarPedido = findViewById(R.id.buttonEnviarPedido);
        buttonAlterar = findViewById(R.id.buttonAlterar);
        buttonRemover = findViewById(R.id.buttonRemover);

        setores = new ArrayList<>();
        produtos = new ArrayList<>();
        itensPedido = new ArrayList<>();

        setorAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, setores);
        produtoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, produtos);
        itensPedidoAdapter = new ItensAdapter(this, itensPedido);

        spinnerSetor.setAdapter(setorAdapter);
        spinnerProduto.setAdapter(produtoAdapter);
        listViewItensPedido.setAdapter(itensPedidoAdapter);
        spinnerSetor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Setor selectedSetor = (Setor) parent.getItemAtPosition(position);
                carregarProdutosPorSetor(selectedSetor.getId());
                if (produtos.isEmpty())
                    Toast.makeText(PedidoActivity.this, "Não existem produtos nessa categoria", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        buttonAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarItemPedido();
            }
        });

        buttonEnviarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarPedido();
            }
        });

        buttonAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alterarItemSelecionado();
            }
        });

        buttonRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removerItemSelecionado();
            }
        });

        carregarSetores();
    }

    private void carregarSetores() {
        Call<List<Setor>> call = pedidosAPI.listarSetores();
        call.enqueue(new Callback<List<Setor>>() {
            @Override
            public void onResponse(Call<List<Setor>> call, Response<List<Setor>> response) {
                if (response.isSuccessful()) {
                    setores.clear();
                    setores.addAll(response.body());
                    setorAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(PedidoActivity.this, "Erro ao carregar os setores", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Setor>> call, Throwable t) {
                Toast.makeText(PedidoActivity.this, "Erro ao carregar os setores", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void carregarProdutosPorSetor(long idSetor) {
        Call<List<Produto>> call = pedidosAPI.listarProdutosPorSetor(idSetor);
        call.enqueue(new Callback<List<Produto>>() {
            @Override
            public void onResponse(Call<List<Produto>> call, Response<List<Produto>> response) {
                if (response.isSuccessful()) {
                    produtos.clear();
                    produtos.addAll(response.body());
                    produtoAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(PedidoActivity.this, "Erro ao carregar os produtos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Produto>> call, Throwable t) {
                Toast.makeText(PedidoActivity.this, "Erro ao carregar os produtos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void adicionarItemPedido() {
        Produto selectedProduto = (Produto) spinnerProduto.getSelectedItem();
        double quantidade = Double.parseDouble(editTextQuantidade.getText().toString());

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setIdProduto(selectedProduto.getId());
        itemPedido.setQuantidade(quantidade);
        itemPedido.setPrecoUnitario(selectedProduto.getPreco());

        itensPedido.add(itemPedido);
        itensPedidoAdapter.notifyDataSetChanged();

        Toast.makeText(this, "Item adicionado ao pedido", Toast.LENGTH_SHORT).show();
    }

    private void enviarPedido() {
        String cpfCliente = editTextCpf.getText().toString();
        long idVendedor = Long.parseLong(editTextVendedor.getText().toString());
        double percentualDesconto = Double.parseDouble(editTextPercentual.getText().toString());
        data = new Date();
        Pedido pedido = new Pedido();
        pedido.setData(simpleDateFormat.format(data));
        pedido.setCpfCliente(cpfCliente);
        pedido.setIdVendedor(idVendedor);
        pedido.setItens(itensPedido);
        pedido.setPercentualDesconto(percentualDesconto);


        Call<Void> call = pedidosAPI.criarPedido(pedido);
        call.enqueue(new Callback<Void>() {

            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(PedidoActivity.this, "Pedido enviado com sucesso", Toast.LENGTH_SHORT).show();
                    limparCampos();
                } else {
                    Toast.makeText(PedidoActivity.this, "Erro ao enviar o pedido", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(PedidoActivity.this, "Erro ao enviar o pedido", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void alterarItemSelecionado() {
        int position = listViewItensPedido.getCheckedItemPosition();
        if (position != ListView.INVALID_POSITION) {
            ItemPedido selectedItem = itensPedido.get(position);
            Produto selectedProduto = (Produto) spinnerProduto.getSelectedItem();
            double quantidade = Double.parseDouble(editTextQuantidade.getText().toString());
            selectedItem.setIdProduto(selectedProduto.getId());
            selectedItem.setQuantidade(quantidade);
            selectedItem.setPrecoUnitario(selectedProduto.getPreco());
            itensPedidoAdapter.notifyDataSetChanged();
            Toast.makeText(PedidoActivity.this, "Item alterado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(PedidoActivity.this, "Nenhum item selecionado", Toast.LENGTH_SHORT).show();
        }
    }

    private void removerItemSelecionado() {
        int position = listViewItensPedido.getCheckedItemPosition();
        if (position != ListView.INVALID_POSITION) {
            itensPedido.remove(position);
            itensPedidoAdapter.notifyDataSetChanged();
            Toast.makeText(PedidoActivity.this, "Item removido", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(PedidoActivity.this, "Nenhum item selecionado", Toast.LENGTH_SHORT).show();
        }
    }

    private void limparCampos() {
        editTextCpf.setText("");
        editTextVendedor.setText("");
        editTextPercentual.setText("");
        editTextQuantidade.setText("");
        spinnerSetor.setSelection(0);
        spinnerProduto.setSelection(0);
        listViewItensPedido.clearChoices();
        itensPedido.clear();
        itensPedidoAdapter.notifyDataSetChanged();
    }

    public class ItensAdapter extends ArrayAdapter<ItemPedido> {

        public ItensAdapter(Context context, List<ItemPedido> itensPedido) {
            super(context, 0, itensPedido);
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.item_pedido, parent, false);
            }

            ItemPedido itemPedido = itensPedido.get(position);
            TextView textViewDescricaoItem = view.findViewById(R.id.textViewDescricaoItem);
            TextView textViewQuantidade = view.findViewById(R.id.textViewQuantidade);

            textViewDescricaoItem.setText(itemPedido.getIdProduto().toString());
            textViewQuantidade.setText(String.valueOf(itemPedido.getQuantidade()));

            return view;
        }
    }


}

