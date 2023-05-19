package com.example.trabalho2.control;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCep {

    private static RetrofitCep instance = null;
    private final ViaCepAPI myApi;

    OkHttpClient client = new OkHttpClient.Builder()
            .build();

    private RetrofitCep() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ViaCepAPI.BASE_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(ViaCepAPI.class);
    }

    public static synchronized RetrofitCep getInstance() {
        if (instance == null) {
            instance = new RetrofitCep();
        }
        return instance;
    }

    public ViaCepAPI getMyApi() {
        return myApi;
    }
}
