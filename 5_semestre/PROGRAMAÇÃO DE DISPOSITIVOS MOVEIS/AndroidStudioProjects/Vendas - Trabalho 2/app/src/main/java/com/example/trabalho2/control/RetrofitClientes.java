package com.example.trabalho2.control;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientes {

    private static RetrofitClientes instance = null;
    private final ClientesAPI myApi;

    OkHttpClient client = new OkHttpClient.Builder()
            .build();

    private RetrofitClientes() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ClientesAPI.BASE_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(ClientesAPI.class);
    }

    public static synchronized RetrofitClientes getInstance() {
        if (instance == null) {
            instance = new RetrofitClientes();
        }
        return instance;
    }

    public ClientesAPI getMyApi() {
        return myApi;
    }
}
