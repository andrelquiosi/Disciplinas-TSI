package com.example.trabalho2.control;

import com.example.trabalho2.model.Cliente;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ClientesAPI {

    String BASE_URL = "http://argo.td.utfpr.edu.br/clients/ws/";

    @POST("cliente")
    Call<Void> cadastrarCliente(@Body Cliente cliente);

    @GET("cliente/{cpf}")
    Call<Cliente> buscarCliente(@Path("cpf") String cpf);

    @PUT("cliente/{cpf}")
    Call<Void> atualizarCliente(@Path("cpf") String cpf, @Body Cliente cliente);

    @DELETE("cliente/{cpf}")
    Call<Void> deletarCliente(@Path("cpf") String cpf);

}

