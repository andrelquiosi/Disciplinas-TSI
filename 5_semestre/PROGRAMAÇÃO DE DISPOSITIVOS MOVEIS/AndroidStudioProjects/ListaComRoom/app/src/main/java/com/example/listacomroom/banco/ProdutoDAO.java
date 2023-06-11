package com.example.listacomroom.banco;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.listacomroom.modelo.Produto;

import java.util.List;

@Dao
public interface ProdutoDAO {

    @Insert
    public long inserir(Produto produto);

    @Delete
    public void remover(Produto produto);

    @Update
    public void atualizar(Produto produto);

    @Query("select * from produto where idSetor = :idSetor & idLista = :idLista")
    LiveData<List<Produto>> buscarPorDepartamento(long idSetor, long idLista);

}
