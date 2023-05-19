package com.example.listaaniversarios.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.listaaniversarios.dados.Aniversario;

import java.util.List;

@Dao
public interface AniversarioDao {

    @Insert
    public long inserir(Aniversario aniversario);

    @Update
    public void alterar(Aniversario aniversario);

    @Delete
    public void remover(Aniversario aniversario);

    @Query("select * from Aniversario order by mes,dia")
    public LiveData<List<Aniversario>> listarTodos();

    @Query("select * from Aniversario where mes = :mes")
    public LiveData<List<Aniversario>> filtrarPorMes(int mes);


}
