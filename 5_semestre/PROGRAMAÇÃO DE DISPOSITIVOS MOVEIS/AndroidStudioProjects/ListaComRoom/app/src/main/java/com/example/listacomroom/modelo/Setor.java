package com.example.listacomroom.modelo;

import androidx.room.*;

import java.io.Serializable;

@Entity
public class Setor implements Serializable {

    @PrimaryKey( autoGenerate = true)
    private long idSetor;

    private String descricao;

    public Setor() { }
    @Ignore
    public Setor(String descricao) {
        this.descricao = descricao;
    }
    public long getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(long idSetor) {
        this.idSetor = idSetor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toString() { return descricao; }
}
