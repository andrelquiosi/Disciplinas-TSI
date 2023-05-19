package com.example.listaaniversarios.dados;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.listaaniversarios.dao.AniversarioDao;

@Database(entities = {Aniversario.class}, version = 1)
public abstract class BancoDeDados extends RoomDatabase {
    public abstract AniversarioDao getAniversarioDao();

}
