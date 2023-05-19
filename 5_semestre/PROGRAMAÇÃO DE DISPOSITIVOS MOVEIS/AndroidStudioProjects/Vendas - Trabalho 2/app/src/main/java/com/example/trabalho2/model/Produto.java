package com.example.trabalho2.model;

import java.io.Serializable;

public class Produto implements Serializable {
    private Long id;
    private String descricao;
    private Double preco;
    private Double estoque;
    private Setor setor;

    public Produto() {
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    public Setor getSetor() {
        return setor;
    }


    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return descricao;
    }
}


