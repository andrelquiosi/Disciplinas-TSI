package com.example.listacomroom.banco;

import androidx.room.*;

import com.example.listacomroom.modelo.ListaDeCompras;
import com.example.listacomroom.modelo.Setor;
import com.example.listacomroom.modelo.Produto;

@Database(entities = {Setor.class, Produto.class, ListaDeCompras.class},
        version = 1, exportSchema = false)
public abstract class Banco extends RoomDatabase {

    private static Banco instance;

    public static void setInstance(Banco newInstance) {
        instance = newInstance;
    }

    public static Banco getInstance() {
        return instance;
    }

    public abstract SetorDAO getSetorDAO();

    public abstract ProdutoDAO getProdutoDAO();

    public abstract ListaDeComprasDAO getListaDeComprasDAO();
}
