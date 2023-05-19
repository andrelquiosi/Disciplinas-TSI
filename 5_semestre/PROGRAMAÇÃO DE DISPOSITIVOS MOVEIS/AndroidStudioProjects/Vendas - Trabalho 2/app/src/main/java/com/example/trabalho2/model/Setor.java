package com.example.trabalho2.model;

import java.io.Serializable;

public class Setor implements Serializable {

    private Long id;
    private String descricao;
    private Double margem;

    public Setor() {
    }

    @Override
    public String toString() {
        return descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getMargem() {
        return margem;
    }

    public void setMargem(Double margem) {
        this.margem = margem;
    }
}

