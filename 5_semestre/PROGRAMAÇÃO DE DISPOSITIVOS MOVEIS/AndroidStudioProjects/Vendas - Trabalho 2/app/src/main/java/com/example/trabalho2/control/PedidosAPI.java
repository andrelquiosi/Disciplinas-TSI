package com.example.trabalho2.control;

import com.example.trabalho2.model.Pedido;
import com.example.trabalho2.model.Produto;
import com.example.trabalho2.model.Setor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PedidosAPI {


    String BASE_URL = "http://argo.td.utfpr.edu.br/clients/ws/";

    @GET("produto")
    Call<List<Produto>> listarProdutosPorSetor(@Query("setor") long idSetor);

    @POST("pedido")
    Call<Void> criarPedido(@Body Pedido pedido);

    @PUT("pedido/{idPedido}")
    Call<Pedido> atualizarPedido(@Path("idPedido") int idPedido, @Body Pedido pedido);

    @GET("pedido")
    Call<List<Pedido>> buscarPedidosPorVendedor(@Query("vendedor") String codigoVendedor);

    @GET("setor")
    Call<List<Setor>> listarSetores();


}

