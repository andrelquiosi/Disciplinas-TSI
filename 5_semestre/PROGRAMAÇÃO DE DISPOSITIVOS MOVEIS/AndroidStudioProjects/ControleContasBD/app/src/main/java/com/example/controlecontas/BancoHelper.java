package com.example.controlecontas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoHelper extends SQLiteOpenHelper {

    public BancoHelper(Context ctx) {
        super(ctx, "ContasAPagar", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("create table categoria "+
                "(_id integer not null primary key, "+
                "descricao varchar(300))");
        bd.execSQL("create table conta "+
                "(_id integer not null primary key, "+
                "descricao varchar(300), " +
                "valor numeric(18,2), " +
                "vencimento integer, " +
                "id_categoria integer references categoria(_id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int versaoAntiga, int versaoAtual) {

    }
}
