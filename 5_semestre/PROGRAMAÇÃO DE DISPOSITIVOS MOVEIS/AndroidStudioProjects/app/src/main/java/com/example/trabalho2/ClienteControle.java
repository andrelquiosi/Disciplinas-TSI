package com.example.trabalho2;

import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class ClienteControle extends AppCompatActivity{

    public Cliente cadastroCliente(){

        String cpf = ((EditText) findViewById(R.id.editTextCpf)).getText().toString();
        String nome = ((EditText) findViewById(R.id.editTextNome)).getText().toString();
        String cep = ((EditText) findViewById(R.id.editTextCep)).getText().toString();
        String logradouro = ((EditText) findViewById(R.id.editTextLogradouro)).getText().toString();
        String complemento = ((EditText) findViewById(R.id.editTextComplemento)).getText().toString();
        String bairro = ((EditText) findViewById(R.id.editTextBairro)).getText().toString();
        String numero = ((EditText) findViewById(R.id.editTextNumero)).getText().toString();
        String localidade = ((EditText) findViewById(R.id.editTextLocalidade)).getText().toString();
        String uf = ((EditText) findViewById(R.id.editTextUf)).getText().toString();
        String ddd = ((EditText) findViewById(R.id.editTextDdd)).getText().toString();
        String telefone = ((EditText) findViewById(R.id.editTextTelefone)).getText().toString();

        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        cliente.setNome(nome);
        cliente.setCep(cep);
        cliente.setLogradouro(logradouro);
        cliente.setComplemento(complemento);
        cliente.setBairro(bairro);
        cliente.setNumero(numero);
        cliente.setLocalidade(localidade);
        cliente.setUf(uf);
        cliente.setDdd(ddd);
        cliente.setTelefone(telefone);

        return cliente;
    }

    public void cadastrarCliente(ClientesAPI clientesAPI) throws IOException {

        Call<Void> callCadastro = clientesAPI.cadastrarCliente(cadastroCliente());
        Response<Void> responseCadastro = callCadastro.execute();

    }

    public void buscarCliente(ClientesAPI clientesAPI) throws IOException{
        String cpf = ((EditText) findViewById(R.id.editTextCpf)).getText().toString();
        Call<Cliente> buscaCliente = clientesAPI.buscarCliente(cpf);
        Response<Cliente> responseBusca = buscaCliente.execute();
    }
}
