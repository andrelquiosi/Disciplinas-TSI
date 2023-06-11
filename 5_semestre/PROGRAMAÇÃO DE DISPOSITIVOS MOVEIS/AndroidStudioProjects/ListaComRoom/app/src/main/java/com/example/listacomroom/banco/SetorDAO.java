package com.example.listacomroom.banco;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import com.example.listacomroom.modelo.ListaComProdutos;
import com.example.listacomroom.modelo.Setor;

import java.util.List;

@Dao
public interface SetorDAO {

    @Insert
    public void inserir(Setor setor);

    @Update
    public void alterar(Setor setor);

    @Delete
    public void remover(Setor setor);

    @Query("select * from Setor order by descricao")
    List<Setor> buscarTodos();

    @Transaction
    @Query("select * from Setor where idSetor = :idSetor")
    LiveData<Setor> buscarPorId(long idSetor);
}
