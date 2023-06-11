package com.example.listacomroom.modelo;

import androidx.room.*;

import java.util.Objects;

@Entity
public class Produto {
    @PrimaryKey(autoGenerate = true)
    private long idProduto;

    private String descricao;

    private double quantidade;

    private boolean comprado;

    @ColumnInfo(name="idSetor")
    private long idSetor;
    @ColumnInfo(name="idLista")
    private long idLista;

    public Produto() { }

    @Ignore
    public Produto(String descricao, double quantidade, long idSetor, long idLista) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.idSetor = idSetor;
        this.idLista = idLista;
        this.comprado = false;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    public long getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(long idSetor) {
        this.idSetor = idSetor;
    }

    public long getIdLista() {
        return idLista;
    }

    public void setIdLista(long idLista) {
        this.idLista = idLista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return idProduto == produto.idProduto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduto);
    }

    public String toString() {
        return descricao+"  "+quantidade+"  "+
                (comprado ? "S" : "N");
    }
}
