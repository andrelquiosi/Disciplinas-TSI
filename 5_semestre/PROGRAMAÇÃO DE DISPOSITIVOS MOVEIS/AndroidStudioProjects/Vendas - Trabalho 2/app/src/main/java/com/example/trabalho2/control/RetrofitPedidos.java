package com.example.trabalho2.control;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitPedidos {

    private static RetrofitPedidos instance = null;
    private final PedidosAPI myApi;

    OkHttpClient client = new OkHttpClient.Builder()
            .build();

    private RetrofitPedidos() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(PedidosAPI.BASE_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(PedidosAPI.class);
    }

    public static synchronized RetrofitPedidos getInstance() {
        if (instance == null) {
            instance = new RetrofitPedidos();
        }
        return instance;
    }

    public PedidosAPI getMyApi() {
        return myApi;
    }
}
