package com.example.listacomroom.modelo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class ListaDeCompras implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Long idCompras;
    private String descricao;

    public Long getIdCompras() {
        return idCompras;
    }

    public void setIdCompras(Long idCompras) {
        this.idCompras = idCompras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaDeCompras that = (ListaDeCompras) o;
        return Objects.equals(idCompras, that.idCompras);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompras);
    }
}
