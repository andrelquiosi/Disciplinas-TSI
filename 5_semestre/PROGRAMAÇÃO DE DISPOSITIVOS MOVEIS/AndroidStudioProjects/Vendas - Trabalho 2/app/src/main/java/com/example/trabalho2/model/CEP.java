package com.example.trabalho2.model;

import java.io.Serializable;

public class CEP implements Serializable {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ddd;


    public CEP() {
    }

    public String getCep() {
        return cep;
    }


    public String getLogradouro() {
        return logradouro;
    }


    public String getComplemento() {
        return complemento;
    }


    public String getBairro() {
        return bairro;
    }


    public String getLocalidade() {
        return localidade;
    }


    public String getUf() {
        return uf;
    }


    public String getDdd() {
        return ddd;
    }

}
