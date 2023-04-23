package com.example.financinhas;


import java.io.Serializable;
import java.util.ArrayList;

public class Categoria implements Serializable {

    private String descricao;
    private ArrayList<Conta> contas;
    private double valorTotal;

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    public void calculaValor() {
        double valor = 0;
        for (Conta a :
                contas) {
            valor += (float) a.getValor();
        }
        setValorTotal(valor);
    }
}
