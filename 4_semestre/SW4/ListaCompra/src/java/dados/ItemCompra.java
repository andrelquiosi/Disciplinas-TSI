/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dados;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author aluno
 */
public class ItemCompra implements Serializable {

    int quantidade;
    String descricao;
    Setor setor;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {

            return false;
        }
        final ItemCompra other = (ItemCompra) obj;
        if ((descricao == null && other.descricao != null)
                || (descricao != null && other.descricao == null)
                || (descricao != null && !descricao.equalsIgnoreCase(other.descricao))) {
            return false;
        }
        return true;
    }

}
