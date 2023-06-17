package com.example.listacomroom.banco;

import android.content.Context;

import androidx.room.*;

import com.example.listacomroom.modelo.ListaDeCompras;
import com.example.listacomroom.modelo.Setor;
import com.example.listacomroom.modelo.Produto;

@Database(entities = {Setor.class, Produto.class, ListaDeCompras.class},
        version = 1, exportSchema = false)
public abstract class Banco extends RoomDatabase {

    private static Banco instance;

    public static Banco getBancoInstance(Context context) {
        if(instance == null ) {
            instance = Room.databaseBuilder(context.getApplicationContext(), Banco.class, "AppDB")
                    .allowMainThreadQueries()
                    .build();

        }

        return instance;
    }
    public abstract SetorDAO getSetorDAO();

    public abstract ProdutoDAO getProdutoDAO();

    public abstract ListaDeComprasDAO getListaDeComprasDAO();
}
