package com.example.trabalho2.viw;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.trabalho2.R;
import com.example.trabalho2.model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoActivity extends AppCompatActivity {

    private ListView listViewPedidos;
    private TextView textViewNenhumPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        listViewPedidos = findViewById(R.id.listViewPedidos);
        textViewNenhumPedido = findViewById(R.id.textViewNenhumPedido);

        // Aqui você precisa obter a lista de pedidos e passar para o adaptador
        List<Pedido> listaPedidos = obterListaPedidos();
        PedidoAdapter pedidoAdapter = new PedidoAdapter(this, listaPedidos);

        // Define o adaptador para a ListView
        listViewPedidos.setAdapter(pedidoAdapter);

        // Verifica se a lista de pedidos está vazia e exibe uma mensagem apropriada
        if (listaPedidos.isEmpty()) {
            textViewNenhumPedido.setVisibility(View.VISIBLE);
        } else {
            textViewNenhumPedido.setVisibility(View.GONE);
        }
    }

    // Método de exemplo para obter a lista de pedidos (substitua com sua implementação real)
    private List<Pedido> obterListaPedidos() {
        List<Pedido> listaPedidos = new ArrayList<>();

        // Adicione aqui a lógica para obter os pedidos da sua fonte de dados (API, banco de dados, etc.)

        return listaPedidos;
    }

    public class PedidoAdapter extends ArrayAdapter<Pedido> {

        private Context context;
        private List<Pedido> pedidos;

        public PedidoAdapter(Context context, List<Pedido> pedidos) {
            super(context, 0, pedidos);
            this.context = context;
            this.pedidos = pedidos;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View itemView = convertView;
            if (itemView == null) {
                itemView = LayoutInflater.from(context).inflate(R.layout.item_pedido, parent, false);
            }

            Pedido pedido = pedidos.get(position);

            TextView textViewCpfCliente = itemView.findViewById(R.id.textViewCpfCliente);
            TextView textViewData = itemView.findViewById(R.id.textViewData);
            TextView textViewVendedor = itemView.findViewById(R.id.textViewVendedor);
            TextView textViewTotal = itemView.findViewById(R.id.textViewTotal);

            textViewCpfCliente.setText(pedido.getCpfCliente());
            textViewData.setText((CharSequence) pedido.getData());
            textViewVendedor.setText(String.valueOf(pedido.getIdVendedor()));
            textViewTotal.setText(String.valueOf(pedido.getItens()));

            return itemView;
        }
    }

}
