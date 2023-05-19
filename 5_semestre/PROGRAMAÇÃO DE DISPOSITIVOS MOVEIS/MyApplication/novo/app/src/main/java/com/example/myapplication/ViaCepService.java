package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ViaCepService {

    @GET("{cep}/json/")
    Call<CEP> buscarCEP(@Path("cep") String cep);
}

