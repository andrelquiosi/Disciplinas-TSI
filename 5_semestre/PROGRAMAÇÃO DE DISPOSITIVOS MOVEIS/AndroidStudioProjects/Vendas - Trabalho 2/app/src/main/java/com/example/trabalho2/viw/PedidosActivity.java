package com.example.trabalho2.viw;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalho2.R;
import com.example.trabalho2.control.RetrofitPedidos;
import com.example.trabalho2.model.Pedido;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PedidosActivity extends AppCompatActivity {

    private ListView listViewPedidos;
    private ArrayList<Pedido> pedidos;
    private PedidoAdapter pedidoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        pedidos = new ArrayList<>();

        listViewPedidos = findViewById(R.id.listViewPedidos);
        pedidoAdapter = new PedidoAdapter(this, pedidos);
        listViewPedidos.setAdapter(pedidoAdapter);

    }

    public void buscarPedidos(View view) {
        String codigoVendedor = String.valueOf(((EditText) findViewById(R.id.editTextCodigoVendedor)).getText());
        buscarPedidosDoVendedor(codigoVendedor);
    }

    private void buscarPedidosDoVendedor(String codigoVendedor) {

        Call<List<Pedido>> callPedidos = RetrofitPedidos.getInstance().getMyApi().buscarPedidosPorVendedor(codigoVendedor);
        callPedidos.enqueue(new Callback<List<Pedido>>() {
            @Override
            public void onResponse(Call<List<Pedido>> call, Response<List<Pedido>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        pedidos.clear();
                        pedidos.addAll(response.body());
                        pedidoAdapter.notifyDataSetChanged();
                    } else {
                        showToast("Nenhum pedido encontrado.");
                    }
                } else {
                    showToast("Erro na resposta: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Pedido>> call, Throwable t) {
                if (t instanceof IOException) {
                    showToast("Erro de conexão: " + t.getMessage());
                } else {
                    showToast("Erro: " + t.getMessage());
                }
            }
        });
    }

    public class PedidoAdapter extends ArrayAdapter<Pedido> {

        public PedidoAdapter(Context context, List<Pedido> pedidos) {
            super(context, android.R.layout.simple_list_item_1, pedidos);
        }

        @Override
        public View getView(int posicao, View reciclada, ViewGroup grupo) {
            if (reciclada == null) {
                reciclada = getLayoutInflater().inflate(R.layout.item_pedidos, null);
            }

            Pedido pedido = pedidos.get(posicao);
            TextView textViewCpfCliente = reciclada.findViewById(R.id.textViewCpfCliente);
            TextView textViewData = reciclada.findViewById(R.id.textViewDataPedido);
            TextView textViewTotal = reciclada.findViewById(R.id.textViewDescontoPedido);

            textViewCpfCliente.setText(pedido.getCpfCliente());
            textViewData.setText(pedido.getData());
            textViewTotal.setText(String.valueOf(pedido.getPercentualDesconto()));

            return reciclada;
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
