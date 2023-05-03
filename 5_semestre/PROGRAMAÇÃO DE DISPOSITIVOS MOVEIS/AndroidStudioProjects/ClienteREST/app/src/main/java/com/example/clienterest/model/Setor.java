package com.example.clienterest.model;

import java.io.Serializable;

public class Setor implements Serializable {
    private long id;
    private String descricao;
    private double margem;

    public Setor() { }

    public Setor(long id, String descricao, double margem) {
        this.id = id;
        this.descricao = descricao;
        this.margem = margem;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getMargem() {
        return margem;
    }

    public void setMargem(double margem) {
        this.margem = margem;
    }

    public String toString() {
        return id + " - " + descricao + " - " + margem;
    }

}
