package com.example.trabalho2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ClientesAPI {

    @POST("cliente")
    Call<Void> cadastrarCliente(@Body Cliente cliente);

    @GET("cliente/{cpf}")
    Call<Cliente> buscarCliente(@Path("cpf") String cpf);

    @PUT("cliente/")
    Call<Void> atualizarCliente(@Body Cliente cliente);

}

