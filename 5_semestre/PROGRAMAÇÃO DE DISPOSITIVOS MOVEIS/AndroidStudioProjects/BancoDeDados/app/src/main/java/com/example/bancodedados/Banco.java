package com.example.bancodedados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    public Banco(Context context) {
        super(context, "contas_pagar", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table categoria(_id integer primary key, " +
                " descricao varchar(50))");

        db.execSQL("create table conta(_id integer primary key, " +
                " descricao varchar(100), valor numeric(18,2), " +
                " vencimento timestamp, id_categoria integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
