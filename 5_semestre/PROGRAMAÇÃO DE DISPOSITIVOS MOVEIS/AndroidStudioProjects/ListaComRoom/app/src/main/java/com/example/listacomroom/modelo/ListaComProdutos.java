package com.example.listacomroom.modelo;

import androidx.room.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaComProdutos implements Serializable {

    @Embedded
    ListaDeCompras listaDeCompras;
    @Relation(
            parentColumn = "id",
            entityColumn = "idLista"
    )
    public List<Produto> produtos;

    public ListaComProdutos() {
        this.listaDeCompras = new ListaDeCompras();
        this.produtos = new ArrayList<>();
    }
    public ListaDeCompras getListaDeCompras() {
        return listaDeCompras;
    }

    public void setListaDeCompras(ListaDeCompras listaDeCompras) {
        this.listaDeCompras = listaDeCompras;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
