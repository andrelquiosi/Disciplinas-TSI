package com.example.listacomroom.banco;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;


import com.example.listacomroom.modelo.ListaDeCompras;
import com.example.listacomroom.modelo.Produto;

import java.util.List;

@Dao
public interface ListaDeComprasDAO {

    @Insert
     long inserir(ListaDeCompras listaDeCompras);

    @Delete
     void remover(ListaDeCompras listaDeCompras);

    @Update
     void atualizar(ListaDeCompras listaDeCompras);

    @Transaction
    @Query("select * from ListaDeCompras where idCompras = :idCompras")
    LiveData<List<ListaDeCompras>> buscarPorListaDeCompras(long idCompras);

    @Query("select * from ListaDeCompras order by descricao")
     List<ListaDeCompras> buscarTodos();
}
