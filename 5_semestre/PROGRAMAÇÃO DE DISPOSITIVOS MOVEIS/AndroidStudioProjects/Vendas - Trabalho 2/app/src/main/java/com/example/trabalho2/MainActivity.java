package com.example.trabalho2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.trabalho2.viw.ClienteActivity;
import com.example.trabalho2.viw.PedidoActivity;
import com.example.trabalho2.viw.PedidosActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnListaPedidos = findViewById(R.id.btnListaPedidos);
        btnListaPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ação para consultar pedidos
                Intent intent = new Intent(MainActivity.this, PedidosActivity.class);
                startActivity(intent);
            }
        });

        Button btnCadastrarCliente = findViewById(R.id.btnCadastrarCliente);
        btnCadastrarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ação para cadastrar cliente
                Intent intent = new Intent(MainActivity.this, ClienteActivity.class);
                startActivity(intent);
            }
        });

        Button btnFazerPedido = findViewById(R.id.btnFazerPedido);
        btnFazerPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ação para fazer pedido
                Intent intent = new Intent(MainActivity.this, PedidoActivity.class);
                startActivity(intent);
            }
        });
    }
}