package com.example.listacomroom.modelo;

import androidx.room.*;

import java.util.List;

public class SetorComProdutos {
    @Embedded
    Setor setor;

    @Relation(
        parentColumn="id",
        entityColumn="id_setor"
    )
    public List<Produto> prods;

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public List<Produto> getProds() {
        return prods;
    }

    public void setProds(List<Produto> prods) {
        this.prods = prods;
    }
}
