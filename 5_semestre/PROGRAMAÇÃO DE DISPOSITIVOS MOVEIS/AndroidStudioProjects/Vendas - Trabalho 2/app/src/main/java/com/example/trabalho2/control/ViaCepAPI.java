package com.example.trabalho2.control;

import com.example.trabalho2.model.CEP;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ViaCepAPI {
    String BASE_URL = "https://viacep.com.br/ws/";

    @GET("{cep}/json/")
    Call<CEP> buscarCEP(@Path("cep") String cep);
}

