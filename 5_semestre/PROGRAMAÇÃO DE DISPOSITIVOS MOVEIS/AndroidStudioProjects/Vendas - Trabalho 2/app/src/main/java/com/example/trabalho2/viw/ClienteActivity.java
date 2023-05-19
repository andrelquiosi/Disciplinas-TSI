package com.example.trabalho2.viw;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalho2.R;
import com.example.trabalho2.control.ClientesAPI;
import com.example.trabalho2.control.RetrofitCep;
import com.example.trabalho2.control.RetrofitClientes;
import com.example.trabalho2.model.CEP;
import com.example.trabalho2.model.Cliente;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClienteActivity extends AppCompatActivity {

    private ClientesAPI clientesAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        stateOfNetworkConection();
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_navegation, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.btnCadastrarCliente)
            startActivity(new Intent(this, PedidoActivity.class));

        return super.onOptionsItemSelected(item);
    }

    private static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void stateOfNetworkConection() {
        if (!isNetworkAvailable(this)) {
            Toast.makeText(this, "Sem conexão com a internet. Não é possível usar o aplicativo offline.", Toast.LENGTH_LONG).show();
        }
    }

    public void BuscarCliente(View view) {

        String cpf = ((EditText) findViewById(R.id.editTextCpf)).getText().toString();
        if (!cpf.isEmpty()) {
            buscarClientePorCPF(cpf);
        } else {
            showToast("Por favor, digite um CPF válido");
        }
    }

    private void buscarClientePorCPF(String cpf) {
        Call<Cliente> call = RetrofitClientes.getInstance().getMyApi().buscarCliente(cpf);
        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(@NonNull Call<Cliente> call, @NonNull Response<Cliente> response) {
                if (response.isSuccessful()) {
                    Cliente cliente = response.body();
                    if (cliente != null) {
                        exibirCliente(cliente);
                    } else {
                        Toast.makeText(ClienteActivity.this, "Cliente não encontrado", Toast.LENGTH_SHORT).show();
                    }
                } else {

                    Toast.makeText(ClienteActivity.this, "Erro ao buscar cliente. Código de resposta: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Cliente> call, @NonNull Throwable t) {
                Toast.makeText(ClienteActivity.this, "Erro ao realizar a busca: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void cadastrar(View view) throws IOException {

        cadastrarCliente(clientesAPI);
        clientesAPI = null;
    }

    private void buscarCEP(String cep) {

        Call<CEP> call = RetrofitCep.getInstance().getMyApi().buscarCEP(cep);
        call.enqueue(new Callback<CEP>() {
            @Override
            public void onResponse(@NonNull Call<CEP> call, @NonNull Response<CEP> response) {
                if (response.isSuccessful()) {
                    CEP cepObj = response.body();
                    if (cepObj != null) {
                        exibirCEP(cepObj);
                    } else {
                        showToast("CEP não encontrado");
                    }
                } else {
                    showToast("Erro ao buscar CEP. Código de resposta: " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<CEP> call, @NonNull Throwable t) {

            }

        });
    }

    private void exibirCEP(CEP cep) {

        ((EditText) findViewById(R.id.editTextCep)).setText(cep.getCep());
        ((EditText) findViewById(R.id.editTextLogradouro)).setText(cep.getLogradouro());
        ((EditText) findViewById(R.id.editTextComplemento)).setText(cep.getComplemento());
        ((EditText) findViewById(R.id.editTextBairro)).setText(cep.getBairro());
        ((EditText) findViewById(R.id.editTextLocalidade)).setText(cep.getLocalidade());
        ((EditText) findViewById(R.id.editTextUf)).setText(cep.getUf());
        ((EditText) findViewById(R.id.editTextDdd)).setText(cep.getDdd());


    }

    private void exibirCliente(Cliente cliente) {

        ((EditText) findViewById(R.id.editTextCpf)).setText(cliente.getCpf());
        ((EditText) findViewById(R.id.editTextNome)).setText(cliente.getNome());
        ((EditText) findViewById(R.id.editTextCep)).setText(cliente.getCep());
        ((EditText) findViewById(R.id.editTextNumero)).setText(cliente.getNumero());
        ((EditText) findViewById(R.id.editTextLogradouro)).setText(cliente.getLogradouro());
        ((EditText) findViewById(R.id.editTextComplemento)).setText(cliente.getComplemento());
        ((EditText) findViewById(R.id.editTextBairro)).setText(cliente.getBairro());
        ((EditText) findViewById(R.id.editTextLocalidade)).setText(cliente.getLocalidade());
        ((EditText) findViewById(R.id.editTextUf)).setText(cliente.getUf());
        ((EditText) findViewById(R.id.editTextDdd)).setText(cliente.getDdd());
        ((EditText) findViewById(R.id.editTextTelefone)).setText(cliente.getTelefone());


    }

    private void limparCampos() {
        ((EditText) findViewById(R.id.editTextCpf)).setText("");
        ((EditText) findViewById(R.id.editTextNome)).setText("");
        ((EditText) findViewById(R.id.editTextCep)).setText("");
        ((EditText) findViewById(R.id.editTextLogradouro)).setText("");
        ((EditText) findViewById(R.id.editTextComplemento)).setText("");
        ((EditText) findViewById(R.id.editTextBairro)).setText("");
        ((EditText) findViewById(R.id.editTextLocalidade)).setText("");
        ((EditText) findViewById(R.id.editTextUf)).setText("");
        ((EditText) findViewById(R.id.editTextDdd)).setText("");
    }

    public void buscarCep(View view) {

        String cep = ((EditText) findViewById(R.id.editTextCep)).getText().toString();
        if (!cep.isEmpty()) {
            buscarCEP(cep);
        } else {
            showToast("Por favor, digite um CEP válido");
        }
    }

    public Cliente capturaDadosCriaCliente() {

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

        Call<Void> callCadastroCliente = RetrofitClientes.getInstance().getMyApi().cadastrarCliente(capturaDadosCriaCliente());
        callCadastroCliente.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    showToast("Cliente cadastrado!");
                    limparCampos();
                } else {
                    String errorMessage = "Erro ao cadastrar o cliente. Código de resposta: " + response.code();
                    showToast(errorMessage);

                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                String errorMessage = "Falha na requisição: " + t.getMessage();
                showToast(errorMessage);
            }
        });

    }

    public void alterarCliente(View view) {
        alterarCliente(clientesAPI);
        clientesAPI = null;
    }

    private void alterarCliente(ClientesAPI clientesAPI) {
        String cpf = ((EditText) findViewById(R.id.editTextCpf)).getText().toString();

        Call<Void> callAtualizarCliente = RetrofitClientes.getInstance().getMyApi().atualizarCliente(cpf,capturaDadosCriaCliente());
        callAtualizarCliente.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    showToast("Cliente atualizado");
                    limparCampos();
                } else {
                    showToast("Erro ao atualizar o cliente");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                if (t instanceof IOException) {
                    showToast("Erro de conexão");
                } else {
                    showToast("Erro na requisição");
                }
            }
        });
    }

   public void  deletarCliente(View view){
        deletarCliente(clientesAPI);
       clientesAPI = null;
   }

    private void deletarCliente(ClientesAPI clientesAPI) {
        String cpf = ((EditText) findViewById(R.id.editTextCpf)).getText().toString();

        Call<Void> callAtualizarCliente = RetrofitClientes.getInstance().getMyApi().deletarCliente(cpf);
        callAtualizarCliente.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    showToast("Cliente Deletado");
                    limparCampos();
                } else {
                    showToast("Erro ao deletar o cliente");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                if (t instanceof IOException) {
                    showToast("Erro de conexão");
                } else {
                    showToast("Erro na requisição");
                }
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}