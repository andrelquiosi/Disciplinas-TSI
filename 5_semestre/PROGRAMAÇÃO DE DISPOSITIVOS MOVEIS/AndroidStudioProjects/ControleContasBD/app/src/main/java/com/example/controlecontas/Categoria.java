package com.example.controlecontas;

import java.io.Serializable;
import java.util.ArrayList;

public class Categoria implements Serializable {
    private String descricao;
    private final ArrayList<Conta> contas = new ArrayList<>();

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void adicionar(Conta conta) {
        contas.add( conta );
    }

    public double getTotalContas() {
        double total = 0;
        for (Conta c : contas) {
            total += c.getValor();
        }
        return total;
    }
}
